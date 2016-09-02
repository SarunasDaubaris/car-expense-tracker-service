package com.personalgarage.service.domain.cars.application.interfaces;

import com.personalgarage.service.base.application.interfaces.IRestController;
import com.personalgarage.service.domain.cars.data.dtos.CarsDTO;

import java.util.List;

public interface ICarsController extends IRestController {

    List<CarsDTO> getAllByUserId(String ownerId);
}