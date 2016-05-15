package ru.kpfu.itis.util;

import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.form.CarRegistrForm;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CarRegistrFormTrans {
    public static CarEntity transform(CarRegistrForm form){
        CarEntity car = new CarEntity();
        car.setAir_cond(form.getAir_cond());
        car.setDoors(form.getDoors());
        car.setLuggage(form.getLuggage());
        car.setModel(form.getModel());
        car.setTransmission(form.getTransmission());
        car.setSeats(form.getSeats());
        car.setPhotoPath("/img/cars/car_default.png");
        car.setPrice(form.getPrice());
        car.setStatus(form.getStatus());
        return car;
    }
}
