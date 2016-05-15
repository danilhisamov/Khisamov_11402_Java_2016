package ru.kpfu.itis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.service.ClientService;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/")
public class IndexPageController {
    @Autowired
    ClientService clsr;

    @Autowired
    CarService carService;

    @RequestMapping
    public String getIndexPage(Model model){
        model.addAttribute("orderform",new OrderForm());
        List<CarEntity> cars = carService.getAllCarsByStatus("active");
        model.addAttribute("cars",cars);
        return "index";
    }
}
