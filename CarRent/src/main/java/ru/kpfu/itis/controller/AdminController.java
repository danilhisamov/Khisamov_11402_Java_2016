package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.CarRegistrForm;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.repository.CarRepository;
import ru.kpfu.itis.service.CarService;

import javax.validation.Valid;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CarService carService;

    @RequestMapping
    public String getAdminPage(){
        return "admin";
    }


    @RequestMapping(value = "/car_registration")
    public String getRegNewCarPage(Model model){
        model.addAttribute("regform", new CarRegistrForm());
        return "car_registration";
    }

    @RequestMapping(value = "/car_registration",method = RequestMethod.POST)
    public String regNewCar(@ModelAttribute("regform") @Valid CarRegistrForm form, BindingResult result){
        if (result.hasErrors()) {
            return "car_registration";
        }

        carService.saveNewCar(form);
        return "redirect:/cars";
    }
}
