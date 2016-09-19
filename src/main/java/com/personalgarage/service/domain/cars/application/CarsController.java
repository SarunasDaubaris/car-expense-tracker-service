package com.personalgarage.service.domain.cars.application;

import com.personalgarage.service.base.application.BaseRestController;
import com.personalgarage.service.core.validation.groups.ActionGet;
import com.personalgarage.service.core.validation.groups.ActionInsert;
import com.personalgarage.service.core.validation.groups.ActionUpdate;
import com.personalgarage.service.domain.cars.application.interfaces.ICarsController;
import com.personalgarage.service.domain.cars.application.services.interfaces.ICarsService;
import com.personalgarage.service.domain.cars.data.dtos.CarsDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
public class CarsController extends BaseRestController implements ICarsController {

    private ICarsService carsService;

    public CarsController() {}

    @Autowired
    public CarsController(ICarsService carsService) {
        this.carsService = carsService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO get(@PathVariable("id") @Validated @NotBlank String id) {
        return carsService.get(id);
    }

    @Override
    @GetMapping(value = "/users/{userId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarsDTO> getAllByUserId(@PathVariable("userId") @Validated({ActionGet.class}) @NotBlank String userId) {
        return carsService.getAllByUser(userId);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDTO insert(@RequestBody @Validated({ActionInsert.class}) CarsDTO carsDTO) {
        return carsService.insert(carsDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO update(@RequestBody @Validated({ActionUpdate.class}) CarsDTO carsDTO) {
        return carsService.update(carsDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        carsService.delete(id);
    }
}