package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.form.OrderForm;
import ru.kpfu.itis.service.CarService;

/**
 * @author Danil Khisamov
 *         11-402
 */

public class OrderFormTransform {

    public static OrderEntity transform(OrderForm form, CarService carService, ClientEntity client){
        OrderEntity order = new OrderEntity();
        order.setCar(carService.getCarById(form.getCar_id()));
        order.setClient(client);
        order.setPickUpLoc(form.getPickUpLoc());
        if (form.getDropOffLoc().equals("") || form.getDropOffLoc() == null) {
            order.setDropOffLoc(form.getPickUpLoc());
        }
        order.setPickUpDate(form.getPickUpDate());
        order.setDropOffDate(form.getDropOffDate());
        order.setPickUpTime(form.getPickUpTime());
        order.setDropOffTime(form.getDropOffTime());

        return order;
    }
}
