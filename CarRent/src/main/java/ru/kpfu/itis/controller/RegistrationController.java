package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.service.ClientService;

import javax.validation.Valid;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrPage(Model model) {
        model.addAttribute("regform", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute("regform") @Valid RegistrationForm form, BindingResult result){
        if (result.hasErrors()) {
            return "registration";
        }

        clientService.saveNewClient(form);
        return "redirect:/login";
    }
}
