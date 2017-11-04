package com.personalgarage.service.main.cars.application.services;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.cars.application.components.CarServiceModelMapper;
import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.errors.CarsErrors;
import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import org.apache.commons.lang3.StringUtils;
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
        if (carDTO.getUserId() == null) {
            throw new ApplicationServiceException(CarsErrors.USER_ID_INVALID);
        }
        if (carDTO.getFuelType() == null) {
            throw new ApplicationServiceException(CarsErrors.FUEL_TYPE_NULL);
        }
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
        return carServiceModelMapper.mapByClass(carRepository.save(car), CarDTO.class);
    }

    @Override
    public CarDTO getCarById(Long id) {
        return carServiceModelMapper.mapByClass(carRepository.findOne(id), CarDTO.class);
    }

    @Override
    public List<CarDTO> getAllByUserId(Long userId) {
        return carServiceModelMapper.mapToListByClass(carRepository.findByUserId(userId), CarDTO.class);
    }
}