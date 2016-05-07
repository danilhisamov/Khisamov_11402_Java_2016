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
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.util.OrderFormTransform;

import javax.validation.Valid;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public String makeOrder(@ModelAttribute("orderform") @Valid OrderForm form, BindingResult result){
        System.out.println("!!!!!");
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientEntity client = user.getClient();
        OrderEntity order = OrderFormTransform.transform(form,carService,client);
        orderService.saveNewOrder(order);
        return "redirect:/client";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestParam("text") String text){
        System.out.println(text);
        return "index";
    }
}
