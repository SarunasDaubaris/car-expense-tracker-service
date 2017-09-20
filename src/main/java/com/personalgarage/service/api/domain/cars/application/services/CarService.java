package com.personalgarage.service.api.domain.cars.application.services;

import com.personalgarage.service.api.domain.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.api.domain.cars.persistence.entities.Car;
import com.personalgarage.service.api.domain.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends BaseRestService {

    private CarServiceModelMapper carServiceModelMapper;
    private CarRepository carRepository;

    public CarService() {
    }

    @Autowired
    public CarService(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    public CarDTO get(Long id) {
        return carServiceModelMapper.mapByClass(carRepository.findOne(id), CarDTO.class);
    }

    public List<CarDTO> getAllByUser(Long userId) {
        return carServiceModelMapper.mapToListByClass(carRepository.findByUserId(userId), CarDTO.class);
    }

    public CarDTO insert(CarDTO carDTO) {
        return carServiceModelMapper.mapByClass(carRepository.save(carServiceModelMapper.mapByClass(carDTO, Car.class)), CarDTO.class);
    }

    public CarDTO update(CarDTO carDTO) {
        return carServiceModelMapper.mapByClass(carRepository.save(carServiceModelMapper.mapByClass(carDTO, Car.class)), CarDTO.class);
    }

    public void delete(Long id) {
        carRepository.delete(id);
    }
}