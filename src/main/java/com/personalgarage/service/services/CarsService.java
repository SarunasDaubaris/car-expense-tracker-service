package com.personalgarage.service.services;

import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.entities.Cars;
import com.personalgarage.service.repositories.CarsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService {

    private CarsRepository carsRepository;

    public CarsService() {}

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarsDTO> getAll() {
        return carsRepository.findAll().stream().map(CarsService::convertToDto).
                collect(Collectors.toList());
    }

    public CarsDTO getById(String id) {
        return convertToDto(carsRepository.findOne(id));
    }

    public CarsDTO insert(CarsDTO carsDTO) {
        return convertToDto(carsRepository.insert(convertToEntity(carsDTO)));
    }

    public CarsDTO update(CarsDTO carsDTO) {
        return convertToDto(carsRepository.save(convertToEntity(carsDTO)));
    }

    public void delete(String id) {
        carsRepository.delete(id);
    }

    private static CarsDTO convertToDto(Cars cars) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cars, CarsDTO.class);
    }

    private static Cars convertToEntity(CarsDTO carsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carsDTO, Cars.class);
    }
}