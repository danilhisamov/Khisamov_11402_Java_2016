package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.form.CarRegistrForm;
import ru.kpfu.itis.repository.CarRepository;
import ru.kpfu.itis.service.CarService;
import ru.kpfu.itis.util.CarRegistrFormTrans;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Service
public class CarServiceImpl implements CarService {
    @Qualifier("carRepository")
    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity getCarById(Integer id) {
        return carRepository.findOneById(id);
    }

    @Override
    @Transactional
    public void saveNewCar(CarRegistrForm form) {
        CarEntity carEntity = CarRegistrFormTrans.transform(form);
        carRepository.save(carEntity);
    }

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<CarEntity> getAllCarsByStatus(String status) {
        return carRepository.findAllByStatus(status);
    }

    @Override
    public void changeDescrip(CarRegistrForm form, Integer car_id) {
        CarEntity car = carRepository.findOneById(car_id);
        car.setAir_cond(form.getAir_cond());
        car.setDoors(form.getDoors());
        car.setLuggage(form.getLuggage());
        car.setModel(form.getModel());
        car.setTransmission(form.getTransmission());
        car.setSeats(form.getSeats());
        car.setPrice(form.getPrice());
        car.setStatus(form.getStatus());
        carRepository.save(car);
    }

    @Override
    public Integer getAllCarsCount() {
        return carRepository.getAllCarsCount();
    }

    @Override
    public Integer getActiveCarsCount() {
        return carRepository.getActiveCarsCount();
    }

}
