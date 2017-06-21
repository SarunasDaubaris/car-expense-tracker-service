package com.personalgarage.service.api.domain.cars.application.interfaces;

import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ICarController {

    CarDTO get(Long id);

    List<CarDTO> getAllByUserId(Long userId);

    CarDTO insert(CarDTO carsDTO);

    CarDTO update(CarDTO carsDTO);

    void delete(Long id);
}