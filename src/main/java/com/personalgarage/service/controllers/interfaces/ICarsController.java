package com.personalgarage.service.controllers.interfaces;

import com.personalgarage.service.base.controllers.interfaces.IRestController;
import com.personalgarage.service.dto.CarsDTO;

import java.util.List;

public interface ICarsController extends IRestController {

    List<CarsDTO> getAllByOwner(String ownerId);
}