package com.personalgarage.service.api.domain.cars.application.services.interfaces;

import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICarService {

    CarDTO get(Long id);

    List<CarDTO> getAllByUser(Long userId);

    CarDTO insert(CarDTO carDTO);

    CarDTO update(CarDTO carDTO);

    void delete(Long id);
}