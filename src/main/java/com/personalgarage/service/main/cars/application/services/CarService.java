package com.personalgarage.service.main.cars.application.services;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.errors.CarsErrors;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarService implements ICarService {

    private CarServiceModelMapper carServiceModelMapper;
    private CarRepository carRepository;

    public CarService() {
    }

    @Autowired
    public CarService(CarServiceModelMapper carServiceModelMapper, CarRepository carRepository) {
        this.carServiceModelMapper = carServiceModelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Validate.notNull(carDTO, "carDTO is null");

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
        return carServiceModelMapper.mapByClass(carRepository.save(car), CarDTO.class);
    }

    @Override
    public CarDTO getCarById(Long id) {
        Validate.notNull(id, "id is null");
        Validate.isTrue(id > 0, "id is invalid");

        return carServiceModelMapper.mapByClass(carRepository.findOne(id), CarDTO.class);
    }

    @Override
    public List<CarDTO> getAllCarsByUserId(Long userId) {
        Validate.notNull(userId, "userId is null");
        Validate.isTrue(userId > 0, "userId is invalid");

        return carServiceModelMapper.mapToListByClass(carRepository.findByUserId(userId), CarDTO.class);
    }
}