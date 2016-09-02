package com.personalgarage.service.services;

import com.personalgarage.service.base.services.BaseRestService;
import com.personalgarage.service.base.RestMapper;
import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.entities.Cars;
import com.personalgarage.service.repositories.CarsRepository;
import com.personalgarage.service.services.interfaces.ICarsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarsService extends BaseRestService implements ICarsService {

    private CarsRepository carsRepository;
    private RestMapper<CarsDTO, Cars> restMapper = new RestMapper<>();

    public CarsService() {}

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarsDTO get(String id) {
        return restMapper.convertToDto(carsRepository.findOne(id));
    }

    @Override
    public List<CarsDTO> getAllByUser(String ownerId) {
        return restMapper.convertToDtos(carsRepository.findByOwner(ownerId));
    }

    @Override
    public CarsDTO insert(CarsDTO carsDTO) {
        return restMapper.convertToDto(carsRepository.insert(restMapper.convertToEntity(carsDTO)));
    }

    @Override
    public CarsDTO update(CarsDTO carsDTO) {
        return restMapper.convertToDto(carsRepository.save(restMapper.convertToEntity(carsDTO)));
    }

    @Override
    public void delete(String id) {
        carsRepository.delete(id);
    }
}