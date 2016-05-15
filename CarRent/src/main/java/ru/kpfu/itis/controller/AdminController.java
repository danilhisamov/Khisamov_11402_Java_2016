package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.form.CarRegistrForm;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.repository.CarRepository;
import ru.kpfu.itis.response.ExtendedCarResponse;
import ru.kpfu.itis.response.OrderResponse;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.service.OrderService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

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

    @RequestMapping(value = "/cars")
    public String getAdminCarsPage(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "admin_cars";
    }

    @RequestMapping(value = "/cars/show")
    public @ResponseBody
    List<ExtendedCarResponse> getCars(@RequestParam(value = "choose") String choose) {
        List<CarEntity> cars = null;
        if (!choose.equals("all")) {
            cars = carService.getAllCarsByStatus(choose);
        } else {
            cars = carService.getAllCars();
        }
        List<ExtendedCarResponse> resp = new LinkedList<>();
        for (CarEntity car : cars) {
            ExtendedCarResponse carResp = new ExtendedCarResponse();
            carResp.setId(car.getId());
            carResp.setPrice(car.getPrice());
            carResp.setLuggage(car.getLuggage());
            carResp.setSeats(car.getSeats());
            carResp.setDoors(car.getDoors());
            carResp.setAir_cond(car.getAir_cond());
            carResp.setTransmission(car.getTransmission());
            carResp.setPhotoPath(car.getPhotoPath());
            carResp.setModel(car.getModel());
            carResp.setStatus(car.getStatus());
            resp.add(carResp);
        }
        return resp;
    }

    @RequestMapping(value = "/orders")
    public String getAdminOrdersPage(Model model){
        List<OrderEntity> orders = orderService.getAllOrders();
        model.addAttribute("orders",orders);
        return "admin_orders";
    }

    @RequestMapping(value = "/orders/show")
    public @ResponseBody List<OrderResponse> showOrdersByTime(@RequestParam(value = "time") String time){
        List<OrderEntity> orders = null;
        if (time.equals("past")){
            orders = orderService.getAllPastOrders();
        }else if (time.equals("current")){
            orders = orderService.getAllCurrentOrders();
        }else if (time.equals("future")){
            orders = orderService.getAllFutureOrders();
        }else if (time.equals("all")){
            orders = orderService.getAllOrders();
        }else{
            return new LinkedList<OrderResponse>();
        }

        List<OrderResponse> resp = new LinkedList<>();
        for (OrderEntity orderEntity : orders){
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(orderEntity.getId());
            orderResponse.setClient(orderEntity.getClient().getUser().getFirstname() + "  " + orderEntity.getClient().getUser().getSurname());
            orderResponse.setCar(orderEntity.getCar().getModel());
            orderResponse.setPrice(orderEntity.getPrice());

            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");

            orderResponse.setPickUpLoc(orderEntity.getPickUpLoc());
            orderResponse.setPickUpDate(format.format(orderEntity.getPickUpDate()));
            orderResponse.setPickUpTime(orderEntity.getPickUpTime());

            orderResponse.setDropOffLoc(orderEntity.getDropOffLoc());
            orderResponse.setDropOffDate(format.format(orderEntity.getDropOffDate()));
            orderResponse.setDropOffTime(orderEntity.getDropOffTime());

            resp.add(orderResponse);
        }
        return resp;
    }

    @RequestMapping(value = "/car_change/{id}")
    public String getCarChangePage(Model model,@PathVariable(value = "id") Integer id){
        CarEntity car = carService.getCarById(id);
        model.addAttribute("car",car);
        model.addAttribute("regform",new CarRegistrForm());
        return "admin_car_change";
    }

    @RequestMapping(value = "/car_change/{id}",method = RequestMethod.POST)
    public String saveCarChange(@PathVariable(value = "id") Integer id,@ModelAttribute("regform") @Valid CarRegistrForm form, BindingResult result){
        System.out.println("post-in");
        if (result.hasErrors()) {
            System.out.println("error");
            return "redirect:/admin/car/change/" + id;
        }

        carService.changeDescrip(form,id);

        return "redirect:/admin/cars";
    }
}
