package com.personalgarage.service.main.cars.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.messages.GetAllCarsByUserIdRequest;
import com.personalgarage.service.main.cars.interfaces.messages.GetAllCarsByUserIdResponse;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCarsByUserIdTask extends ServiceTask<GetAllCarsByUserIdRequest, GetAllCarsByUserIdResponse> {

    private final CarServiceModelMapper carServiceModelMapper;
    private final CarRepository carRepository;

    @Autowired
    public GetAllCarsByUserIdTask(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public GetAllCarsByUserIdResponse processDirectly(GetAllCarsByUserIdRequest request) {
        GetAllCarsByUserIdResponse response = new GetAllCarsByUserIdResponse();

        Validate.notNull(request, "getAllCarsByUserIdRequest is null");

        Validate.notNull(request.userId, "userId is null");
        Validate.isTrue(request.userId > 0, "userId is invalid");

        List<Car> cars = carRepository.findByUserId(request.userId);

        response.carDTOs = carServiceModelMapper.mapToListByClass(cars, CarDTO.class);
        return response;
    }
}