package com.personalgarage.service.api.domain.cars.application.services.interfaces;

import com.personalgarage.service.api.domain.cars.data.dtos.CarsDTO;
import com.personalgarage.service.base.application.services.interfaces.IRestService;

import java.util.List;

public interface ICarsService extends IRestService {

    CarsDTO get(String id);

    List<CarsDTO> getAllByUser(String userId);

    CarsDTO insert(CarsDTO carsDTO);

    CarsDTO update(CarsDTO carsDTO);

    void delete(String id);
}