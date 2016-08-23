package com.personalgarage.service.services.interfaces;

import com.personalgarage.service.base.services.interfaces.IRestService;
import com.personalgarage.service.dto.CarsDTO;

import java.util.List;

public interface ICarsService extends IRestService<CarsDTO> {

    List<CarsDTO> getAllByUser(String userId);
}