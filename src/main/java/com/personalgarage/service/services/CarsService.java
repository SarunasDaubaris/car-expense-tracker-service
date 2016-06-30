package com.personalgarage.service.services;

import com.personalgarage.service.base.IDTOBaseService;
import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.entities.Cars;
import com.personalgarage.service.repositories.CarsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService extends IDTOBaseService<CarsDTO, Cars> {

    private CarsRepository carsRepository;

    public CarsService() {}

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<CarsDTO> getAll() {
        return carsRepository.findAll().stream().map(cars -> convertToDto(cars)).
                collect(Collectors.toList());
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