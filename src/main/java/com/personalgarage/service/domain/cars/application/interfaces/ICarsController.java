package com.personalgarage.service.domain.cars.application.interfaces;

import com.personalgarage.service.base.application.interfaces.IRestController;
import com.personalgarage.service.domain.cars.data.dtos.CarsDTO;

import java.util.List;

public interface ICarsController extends IRestController {

    CarsDTO get(String id);

    List<CarsDTO> getAllByUserId(String userId);

    CarsDTO insert(CarsDTO carsDTO);

    CarsDTO update(CarsDTO carsDTO);

    void delete(String id);
}