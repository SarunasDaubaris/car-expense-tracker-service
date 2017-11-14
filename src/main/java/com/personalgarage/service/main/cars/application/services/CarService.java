package com.personalgarage.service.main.cars.application.services;

import com.personalgarage.service.base.application.ServiceTaskCreator;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.application.tasks.CreateCarTask;
import com.personalgarage.service.main.cars.application.tasks.GetAllCarsByUserIdTask;
import com.personalgarage.service.main.cars.application.tasks.GetCarByIdTask;
import com.personalgarage.service.main.cars.interfaces.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarService implements ICarService {

    private final ServiceTaskCreator serviceTaskCreator;

    @Autowired
    public CarService(ServiceTaskCreator serviceTaskCreator) {
        this.serviceTaskCreator = serviceTaskCreator;
    }

    @Override
    public CreateCarResponse createCar(CreateCarRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(CreateCarTask.class).processInTransaction(request);
    }

    @Override
    public GetCarByIdResponse getCarById(GetCarByIdRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(GetCarByIdTask.class).processInTransaction(request);
    }

    @Override
    public GetAllCarsByUserIdResponse getAllCarsByUserId(GetAllCarsByUserIdRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(GetAllCarsByUserIdTask.class).processInTransaction(request);
    }
}
