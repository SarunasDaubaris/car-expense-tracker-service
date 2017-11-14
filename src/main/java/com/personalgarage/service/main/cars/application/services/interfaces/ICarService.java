package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.cars.interfaces.messages.*;

public interface ICarService {

    CreateCarResponse createCar(CreateCarRequest request) throws ApplicationServiceException;

    GetCarByIdResponse getCarById(GetCarByIdRequest request) throws ApplicationServiceException;

    GetAllCarsByUserIdResponse getAllCarsByUserId(GetAllCarsByUserIdRequest request) throws ApplicationServiceException;
}