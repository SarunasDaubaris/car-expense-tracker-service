package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;

import java.util.List;

public interface ICarService {

    CarDTO getByCarId(Long id);

    List<CarDTO> getAllCarsByUserId(Long userId);

    CarDTO createCar(CarDTO carDTO);
}