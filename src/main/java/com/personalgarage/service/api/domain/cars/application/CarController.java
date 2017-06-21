package com.personalgarage.service.api.domain.cars.application;

import com.personalgarage.service.api.domain.cars.application.interfaces.ICarController;
import com.personalgarage.service.api.domain.cars.application.services.interfaces.ICarService;
import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.common.validation.groups.ActionGet;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/cars")
public class CarController implements ICarController {

    private ICarService carService;

    public CarController() {
    }

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return carService.get(id);
    }

    @Override
    @GetMapping(value = "/users/{userId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDTO> getAllByUserId(@PathVariable("userId") @Validated({ActionGet.class}) @NotBlank Long userId) {
        return carService.getAllByUser(userId);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO insert(@RequestBody @Validated({ActionInsert.class}) CarDTO carsDTO) {
        return carService.insert(carsDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDTO update(@RequestBody @Validated({ActionUpdate.class}) CarDTO carsDTO) {
        return carService.update(carsDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotNull Long id) {
        carService.delete(id);
    }
}