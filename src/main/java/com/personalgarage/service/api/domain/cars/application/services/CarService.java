package com.personalgarage.service.api.domain.cars.application.services;

import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.api.domain.cars.persistence.entities.Car;
import com.personalgarage.service.api.domain.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends BaseRestService {

    private final DomainDataMapper<CarDTO, Car> domainDataMapper = new DomainDataMapper<>();

    private CarRepository carRepository;

    public CarService() {
    }

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDTO get(Long id) {
        return domainDataMapper.convertToDto(carRepository.findOne(id));
    }

    public List<CarDTO> getAllByUser(Long userId) {
        return domainDataMapper.convertToDtos(carRepository.findByUserId(userId));
    }

    public CarDTO insert(CarDTO carDTO) {
        return domainDataMapper.convertToDto(carRepository.save(domainDataMapper.convertToEntity(carDTO)));
    }

    public CarDTO update(CarDTO carDTO) {
        return domainDataMapper.convertToDto(carRepository.save(domainDataMapper.convertToEntity(carDTO)));
    }

    public void delete(Long id) {
        carRepository.delete(id);
    }
}