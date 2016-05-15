package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.service.ClientService;
import ru.kpfu.itis.service.OrderService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
public class PdfController {
    @Autowired
    OrderService orderService;

    @Autowired
    CarService carService;

    @Autowired
    ClientService clientService;


    @RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
    public ModelAndView generatePdf(){
        List<OrderEntity> orders = orderService.getAllOrders();

        Integer allCars = carService.getAllCarsCount();
        Integer allActiveCars = carService.getActiveCarsCount();
        Integer allPassiveCars = allCars - allActiveCars;

        Integer allOrdersSum = orderService.getSumOfOrders();

        Integer allClients = clientService.getAllClientCount();

        ModelAndView modelAndView = new ModelAndView("pdfView");
        modelAndView.addObject("allCars",allCars);
        modelAndView.addObject("allActiveCars",allActiveCars);
        modelAndView.addObject("allPassiveCars",allPassiveCars);
        modelAndView.addObject("allOrdersSum",allOrdersSum);
        modelAndView.addObject("allClients",allClients);

        return modelAndView;
    }
}
