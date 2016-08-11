package com.personalgarage.service.controllers;

import com.personalgarage.service.base.controllers.BaseRestController;
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

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO get(@PathVariable("id") @Validated @NotBlank String id) {
        return carsService.get(id);
    }

    @Override
    @RequestMapping(value = "/cars/{ownerId}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarsDTO> getAllByOwner(String ownerId) {
        return carsService.getAllByOwner(ownerId);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDTO insert(@RequestBody @Validated({ActionInsert.class}) CarsDTO carsDTO) {
        return carsService.insert(carsDTO);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO update(@RequestBody @Validated({ActionUpdate.class}) CarsDTO carsDTO) {
        return carsService.update(carsDTO);
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        carsService.delete(id);
    }
}