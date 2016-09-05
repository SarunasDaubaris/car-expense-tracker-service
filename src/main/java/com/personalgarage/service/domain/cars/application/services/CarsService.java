package com.personalgarage.service.domain.cars.application.services;

import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.core.DomainDataMapper;
import com.personalgarage.service.domain.cars.application.services.interfaces.ICarsService;
import com.personalgarage.service.domain.cars.data.dtos.CarsDTO;
import com.personalgarage.service.domain.cars.persistence.entities.Cars;
import com.personalgarage.service.domain.cars.persistence.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarsService extends BaseRestService implements ICarsService {

    private CarsRepository carsRepository;
    private DomainDataMapper<CarsDTO, Cars> domainDataMapper = new DomainDataMapper<>();

    public CarsService() {}

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarsDTO get(String id) {
        return domainDataMapper.convertToDto(carsRepository.findOne(id));
    }

    @Override
    public List<CarsDTO> getAllByUser(String ownerId) {
        return domainDataMapper.convertToDtos(carsRepository.findByOwner(ownerId));
    }

    @Override
    public CarsDTO insert(CarsDTO carsDTO) {
        return domainDataMapper.convertToDto(carsRepository.insert(domainDataMapper.convertToEntity(carsDTO)));
    }

    @Override
    public CarsDTO update(CarsDTO carsDTO) {
        return domainDataMapper.convertToDto(carsRepository.save(domainDataMapper.convertToEntity(carsDTO)));
    }

    @Override
    public void delete(String id) {
        carsRepository.delete(id);
    }
}