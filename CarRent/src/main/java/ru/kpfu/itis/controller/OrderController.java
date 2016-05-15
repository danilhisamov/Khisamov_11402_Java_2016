package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.service.ClientService;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.util.DateTransform;
import ru.kpfu.itis.util.OrderFormTransform;

import javax.validation.Valid;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ClientService clientService;

    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public String makeOrder(@ModelAttribute("orderform") @Valid OrderForm form, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/";
        }
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientEntity client = user.getClient();
        OrderEntity order = OrderFormTransform.transform(form,carService,client);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Calendar beginDate1 = DateTransform.transformDate(dateFormat.format(order.getPickUpDate()),order.getPickUpTime());
        Calendar endDate1 = DateTransform.transformDate(dateFormat.format(order.getDropOffDate()),order.getDropOffTime());

        if (beginDate1.after(endDate1)){
            return "redirect:/?error=incorrect_date";
        }

        List<OrderEntity> orders = orderService.getAllByCarId(order.getCar().getId());
        boolean cross = false;
        Iterator<OrderEntity> iterator = orders.iterator();
        while (iterator.hasNext() && !cross){
            OrderEntity mBOrder = iterator.next();
            Calendar beginDate2 = DateTransform.transformDate(dateFormat.format(mBOrder.getPickUpDate()),mBOrder.getPickUpTime());
            Calendar endDate2 = DateTransform.transformDate(dateFormat.format(mBOrder.getDropOffDate()),mBOrder.getDropOffTime());

            if (!(beginDate2.after(endDate1) || endDate2.before(beginDate1))){
                cross = true;
            }
        }

        if (!cross){
            long beg = beginDate1.getTimeInMillis();
            long end = endDate1.getTimeInMillis();

            Integer hours = (int)((end - beg)/(1000 * 60 * 60));
            Integer price = hours * order.getCar().getPrice();
            Integer disc = client.getDiscount();
            price = (int)(((100.0 - disc)/100) * price);
            order.setPrice(price);
            orderService.saveNewOrder(order);
            client.setRides_count(client.getRides_count() + 1);
            clientService.save(client);
            if (((client.getRides_count() % 5) == 0)&&(client.getRides_count() != 0)){
                client.setDiscount(client.getDiscount() + 1);
            }

            return "redirect:/client/rides";
        }else{
            return "redirect:/?dateError=true";
        }

    }

}
