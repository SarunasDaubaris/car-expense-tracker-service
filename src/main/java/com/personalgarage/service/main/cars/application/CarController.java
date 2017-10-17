package com.personalgarage.service.main.cars.application;

import com.personalgarage.service.interfaces.common.validation.groups.ActionInsert;
import com.personalgarage.service.interfaces.common.validation.groups.ActionUpdate;
import com.personalgarage.service.interfaces.main.cars.dtos.CarDTO;
import com.personalgarage.service.main.cars.application.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return carService.get(id);
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDTO> getAllByUserId(@PathVariable("userId") @Validated @NotNull Long userId) {
        return carService.getAllByUser(userId);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO insert(@RequestBody @Validated({ActionInsert.class}) CarDTO carsDTO) {
        return carService.insert(carsDTO);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO update(@RequestBody @Validated({ActionUpdate.class}) CarDTO carsDTO) {
        return carService.update(carsDTO);
    }
}