package com.personalgarage.service.api.domain.cars.application.services;

import com.personalgarage.service.api.domain.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.api.domain.cars.persistence.entities.Car;
import com.personalgarage.service.api.domain.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService extends BaseRestService implements ICarService {

    private final DomainDataMapper<CarDTO, Car> domainDataMapper = new DomainDataMapper<>();

    private CarRepository carRepository;

    public CarService() {
    }

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO get(Long id) {
        return domainDataMapper.convertToDto(carRepository.findOne(id));
    }

    @Override
    public List<CarDTO> getAllByUser(Long userId) {
        return domainDataMapper.convertToDtos(carRepository.findByUser(userId));
    }

    @Override
    public CarDTO insert(CarDTO carDTO) {
        return domainDataMapper.convertToDto(carRepository.save(domainDataMapper.convertToEntity(carDTO)));
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        return domainDataMapper.convertToDto(carRepository.save(domainDataMapper.convertToEntity(carDTO)));
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }
}