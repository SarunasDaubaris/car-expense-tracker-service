package com.personalgarage.service.main.cars.application.services;

import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarService implements ICarService {

    private CarServiceModelMapper carServiceModelMapper;
    private CarRepository carRepository;

    public CarService() {
    }

    @Autowired
    public CarService(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO getByCarId(Long id) {
        return carServiceModelMapper.mapByClass(carRepository.findOne(id), CarDTO.class);
    }

    @Override
    public List<CarDTO> getAllCarsByUserId(Long userId) {
        return carServiceModelMapper.mapToListByClass(carRepository.findByUserId(userId), CarDTO.class);
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = carServiceModelMapper.mapByClass(carDTO, Car.class);
        return carServiceModelMapper.mapByClass(carRepository.save(car), CarDTO.class);
    }
}