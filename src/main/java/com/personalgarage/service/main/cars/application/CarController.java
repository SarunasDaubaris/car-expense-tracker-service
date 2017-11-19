package com.personalgarage.service.main.cars.application;

import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import com.personalgarage.service.main.cars.interfaces.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private ICarService carService;

    public CarController() {
    }

    @Autowired
    public CarController(@Qualifier("carService") ICarService carService) {
        this.carService = carService;
    }

    @PreAuthorize("@applicationUserAccessService.isAccessibleWithUserId(authentication, #carDTO.userId)")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long createCar(@RequestBody @Validated @NotNull CarDTO carDTO) {
        CreateCarRequest request = new CreateCarRequest();
        request.carDTO = carDTO;
        CreateCarResponse createCarResponse = carService.createCar(request);
        return createCarResponse.carId;
    }

    @PreAuthorize("@carAccessService.isAccessibleWithCarId(authentication, #id)")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CarDTO getCarById(@PathVariable("id") @Validated @NotNull Long id) {
        GetCarByIdRequest request = new GetCarByIdRequest();
        request.carId = id;
        GetCarByIdResponse response = carService.getCarById(request);
        return response.carDTO;
    }

    @PreAuthorize("@applicationUserAccessService.isAccessibleWithUserId(authentication, #userId)")
    @PostFilter("filterObject.userId == #userId")
    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CarDTO> getAllCarsByUserId(@PathVariable("userId") @Validated @NotNull Long userId) {
        GetAllCarsByUserIdRequest request = new GetAllCarsByUserIdRequest();
        request.userId = userId;
        GetAllCarsByUserIdResponse response = carService.getAllCarsByUserId(request);
        return response.carDTOs;
    }
}