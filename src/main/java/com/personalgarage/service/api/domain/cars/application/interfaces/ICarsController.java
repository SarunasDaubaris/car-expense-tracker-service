package com.personalgarage.service.api.domain.cars.application.interfaces;

import com.personalgarage.service.api.domain.cars.data.dtos.CarsDTO;
import com.personalgarage.service.base.application.interfaces.IRestController;

import java.util.List;

public interface ICarsController extends IRestController {

    CarsDTO get(String id);

    List<CarsDTO> getAllByUserId(String userId);

    CarsDTO insert(CarsDTO carsDTO);

    CarsDTO update(CarsDTO carsDTO);

    void delete(String id);
}