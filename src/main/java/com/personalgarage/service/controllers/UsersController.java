package com.personalgarage.service.controllers;

import com.personalgarage.service.base.controllers.BaseRestController;
import com.personalgarage.service.base.validation.groups.ActionGet;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.controllers.interfaces.IUsersController;
import com.personalgarage.service.dto.UsersDTO;
import com.personalgarage.service.services.interfaces.IUsersService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public class UsersController extends BaseRestController implements IUsersController {

    private IUsersService usersService;

    public UsersController() {}

    @Autowired
    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UsersDTO get(@PathVariable("id") @Validated({ActionGet.class}) @NotBlank String id) {
        return usersService.get(id);
    }

    @PostMapping(value = "/users", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersDTO insert(@RequestBody @Validated({ActionInsert.class}) UsersDTO usersDTO) {
        return usersService.insert(usersDTO);
    }

    @PutMapping(value = "/users", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UsersDTO update(@RequestBody @Validated({ActionUpdate.class}) UsersDTO usersDTO) {
        return usersService.update(usersDTO);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        usersService.delete(id);
    }
}