package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
            System.out.println("ALERT ERROR ERROR");
        }
        return "login";
    }
}
