package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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
    public void saveNewCar(CarRegistrForm form) {
        CarEntity carEntity = CarRegistrFormTrans.transform(form);
        carRepository.save(carEntity);
    }

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

}
