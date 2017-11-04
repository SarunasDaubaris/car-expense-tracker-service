package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;

import java.util.List;

public interface ICarService {

    CarDTO createCar(CarDTO carDTO);

    CarDTO getCarById(Long id);

    List<CarDTO> getAllByUserId(Long userId);
}