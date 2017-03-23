package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.service.OrderService;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String getClientPage(Model model){
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientEntity client = user.getClient();
        model.addAttribute("user",user);
        model.addAttribute("client",client);
        return "client";
    }

    @RequestMapping(value = "/rides",method = RequestMethod.GET)
    public String getRidesPage(Model model){
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<OrderEntity> list = orderService.getRidesByUserId(user.getId());
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return "client_rides";
    }
}
