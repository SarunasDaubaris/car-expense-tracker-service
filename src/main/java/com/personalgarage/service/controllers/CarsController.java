package com.personalgarage.service.controllers;

import com.personalgarage.service.base.controllers.BaseRestController;
import com.personalgarage.service.base.validation.groups.ActionGet;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.controllers.interfaces.ICarsController;
import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.services.interfaces.ICarsService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarsController extends BaseRestController implements ICarsController {

    private ICarsService carsService;

    public CarsController() {}

    @Autowired
    public CarsController(ICarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping(value = "/cars/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO get(@PathVariable("id") @Validated({ActionGet.class}) @NotBlank String id) {
        return carsService.get(id);
    }

    @Override
    @GetMapping(value = "/cars/users/{userId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarsDTO> getAllByUserId(@PathVariable("userId") @Validated({ActionGet.class}) @NotBlank String userId) {
        return carsService.getAllByUser(userId);
    }

    @PostMapping(value = "/cars", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDTO insert(@RequestBody @Validated({ActionInsert.class}) CarsDTO carsDTO) {
        return carsService.insert(carsDTO);
    }

    @PutMapping(value = "/cars", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO update(@RequestBody @Validated({ActionUpdate.class}) CarsDTO carsDTO) {
        return carsService.update(carsDTO);
    }

    @DeleteMapping(value = "/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        carsService.delete(id);
    }
}