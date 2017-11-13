package com.personalgarage.service.main.cars.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.messages.GetCarByIdRequest;
import com.personalgarage.service.main.cars.interfaces.messages.GetCarByIdResponse;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCarByIdTask extends ServiceTask<GetCarByIdRequest, GetCarByIdResponse> {

    private final CarServiceModelMapper carServiceModelMapper;
    private final CarRepository carRepository;

    @Autowired
    public GetCarByIdTask(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public GetCarByIdResponse processDirectly(GetCarByIdRequest request) {
        GetCarByIdResponse response = new GetCarByIdResponse();

        Validate.notNull(request, "getCarByIdRequest is null");

        Validate.notNull(request.carId, "carId is null");
        Validate.isTrue(request.carId > 0, "carId is invalid");

        Car car = Validate.notNull(carRepository.findOne(request.carId), "failed to find car #%s", request.carId);

        response.carDTO = carServiceModelMapper.mapByClass(car, CarDTO.class);
        return response;
    }
}