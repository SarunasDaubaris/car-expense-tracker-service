package com.personalgarage.service.main.cars.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.errors.CarsErrors;
import com.personalgarage.service.main.cars.interfaces.messages.CreateCarRequest;
import com.personalgarage.service.main.cars.interfaces.messages.CreateCarResponse;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCarTask extends ServiceTask<CreateCarRequest, CreateCarResponse> {

    private final CarServiceModelMapper carServiceModelMapper;
    private final CarRepository carRepository;

    @Autowired
    public CreateCarTask(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CreateCarResponse processDirectly(CreateCarRequest request) {
        CreateCarResponse response = new CreateCarResponse();

        Validate.notNull(request, "createCarRequest is null");

        CarDTO carDTO = Validate.notNull(request.carDTO, "carDTO is null");

        Validate.notNull(carDTO.getUserId(), "userId is null");
        Validate.isTrue(carDTO.getUserId() > 0, "userId is invalid");

        Validate.notNull(carDTO.getFuelType(), "fuelType is null");

        if (StringUtils.isBlank(carDTO.getLicencePlate())) {
            throw new ApplicationServiceException(CarsErrors.LICENCE_PLATE_BLANK);
        }

        if (StringUtils.isBlank(carDTO.getMake())) {
            throw new ApplicationServiceException(CarsErrors.MAKE_BLANK);
        }

        if (StringUtils.isBlank(carDTO.getModel())) {
            throw new ApplicationServiceException(CarsErrors.MODEL_BLANK);
        }

        if (carDTO.getManufactureYear() == null || carDTO.getManufactureYear() <= 0) {
            throw new ApplicationServiceException(CarsErrors.MANUFACTURE_YEAR_INVALID);
        }

        Car car = carServiceModelMapper.mapByClass(carDTO, Car.class);
        car.setCreatedDate(DateTime.now(DateTimeZone.UTC));

        carRepository.save(car);

        response.carId = car.getId();
        return response;
    }
}