package com.personalgarage.service.main.cars.application.services.interfaces;

import com.personalgarage.service.main.cars.interfaces.messages.*;

public interface ICarService {

    CreateCarResponse createCar(CreateCarRequest request);

    GetCarByIdResponse getCarById(GetCarByIdRequest request);

    GetAllCarsByUserIdResponse getAllCarsByUserId(GetAllCarsByUserIdRequest request);
}