package com.personalgarage.service.services;

import com.personalgarage.service.base.services.BaseRestService;
import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.entities.Cars;
import com.personalgarage.service.repositories.CarsRepository;
import com.personalgarage.service.services.interfaces.ICarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarsService extends BaseRestService<CarsDTO, Cars> implements ICarsService<CarsDTO> {

    private CarsRepository carsRepository;

    public CarsService() {}

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarsDTO get(String id) {
        return convertToDto(carsRepository.findOne(id));
    }

    @Override
    public CarsDTO insert(CarsDTO carsDTO) {
        return convertToDto(carsRepository.insert(convertToEntity(carsDTO)));
    }

    @Override
    public CarsDTO update(CarsDTO carsDTO) {
        return convertToDto(carsRepository.save(convertToEntity(carsDTO)));
    }

    @Override
    public void delete(String id) {
        carsRepository.delete(id);
    }

    protected CarsDTO convertToDto(Cars cars) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cars, CarsDTO.class);
    }

    protected Cars convertToEntity(CarsDTO carsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carsDTO, Cars.class);
    }
}