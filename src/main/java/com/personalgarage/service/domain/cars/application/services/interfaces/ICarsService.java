package com.personalgarage.service.domain.cars.application.services.interfaces;

import com.personalgarage.service.base.application.services.interfaces.IRestService;
import com.personalgarage.service.domain.cars.data.dtos.CarsDTO;

import java.util.List;

public interface ICarsService extends IRestService<CarsDTO> {

    List<CarsDTO> getAllByUser(String userId);
}