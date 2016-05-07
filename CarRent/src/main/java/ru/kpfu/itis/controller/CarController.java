package ru.kpfu.itis.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.repository.CarRepository;
import ru.kpfu.itis.repository.ClientRepository;
import ru.kpfu.itis.response.CarResponse;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.service.ClientService;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping
    public String getCarPage(Model model){
        UserEntity user = null;
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")){
            user = (UserEntity) object;
        }
        List<CarEntity> cars = carService.getAllCars();
        CarEntity car = carService.getCarById(1);
        model.addAttribute("car",car);
        model.addAttribute("cars",cars);
        model.addAttribute("user",user);
        return "cars";
    }

    @RequestMapping(value = "/process",method = RequestMethod.GET)
    public @ResponseBody
    CarResponse getIdCarPage(@RequestParam Integer id){
        CarEntity car = carService.getCarById(id);
        CarResponse carResp = new CarResponse();
        carResp.setPrice(car.getPrice());
        carResp.setLuggage(car.getLuggage());
        carResp.setSeats(car.getSeats());
        carResp.setDoors(car.getDoors());
        carResp.setAir_cond(car.getAir_cond());
        carResp.setTransmission(car.getTransmission());
        carResp.setPhotoPath(car.getPhotoPath());
        carResp.setModel(car.getModel());
        return carResp;
    }
}
