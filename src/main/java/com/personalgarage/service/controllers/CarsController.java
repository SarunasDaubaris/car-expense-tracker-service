package com.personalgarage.service.controllers;

import com.personalgarage.service.dto.CarsDTO;
import com.personalgarage.service.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarsController {

    private CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarsDTO> getAll() {
        return carsService.getAll();
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO getById(@PathVariable("id") String id) {
        return carsService.get(id);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDTO insert(@RequestBody CarsDTO carsDTO) {
        return carsService.insert(carsDTO);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarsDTO update(@RequestBody CarsDTO carsDTO) {
        return carsService.update(carsDTO);
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        carsService.delete(id);
    }
}