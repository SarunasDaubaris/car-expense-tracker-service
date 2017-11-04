package com.personalgarage.service.main.cars.application;

import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CarDTO createCar(@RequestBody @Validated @NotNull CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CarDTO getCarById(@PathVariable("id") @Validated @NotNull Long id) {
        return carService.getCarById(id);
    }

    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CarDTO> getAllByUserId(@PathVariable("userId") @Validated @NotNull Long userId) {
        return carService.getAllByUserId(userId);
    }
}