package ru.kpfu.itis.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.entity.enums.Role;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/identify")
public class IdentificationController {

    @RequestMapping(method = RequestMethod.GET)
    public String identificateUser(){
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user.getRole().equals(Role.ROLE_ADMIN)){
            return "redirect:/admin";
        }else if (user.getRole().equals(Role.ROLE_CLIENT)){
            return "redirect:/client";
        }

        return "redirect:registration";
    }
}
