package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.form.CarRegistrForm;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface CarService {
    CarEntity getCarById(Integer id);
    void saveNewCar(CarRegistrForm form);
    List<CarEntity> getAllCars();
    List<CarEntity> getAllCarsByStatus(String status);
    void changeDescrip(CarRegistrForm form,Integer car_id);
    Integer getAllCarsCount();
    Integer getActiveCarsCount();
}
