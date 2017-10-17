package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.main.cars.data.dtos.CarDTO;

import java.util.List;

public interface ICarService {
    CarDTO get(Long id);

    List<CarDTO> getAllByUser(Long userId);

    CarDTO insert(CarDTO carDTO);

    CarDTO update(CarDTO carDTO);
}