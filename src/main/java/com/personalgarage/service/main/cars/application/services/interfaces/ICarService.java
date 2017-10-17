package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.interfaces.main.cars.dtos.CarDTO;
import java.util.List;

public interface ICarService {
    CarDTO get(Long id);

    List<CarDTO> getAllByUser(Long userId);

    CarDTO insert(CarDTO carDTO);

    CarDTO update(CarDTO carDTO);
}