package com.personalgarage.service.api.domain.users.application;

import com.personalgarage.service.api.domain.users.application.services.interfaces.IUserService;
import com.personalgarage.service.base.application.BaseRestController;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import com.personalgarage.service.api.domain.users.application.interfaces.IUserController;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public class UserController extends BaseRestController implements IUserController {

    private IUserService usersService;

    public UserController() {}

    @Autowired
    public UserController(IUserService usersService) {
        this.usersService = usersService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO get(@PathVariable("id") @Validated @NotBlank String id) {
        return usersService.get(id);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO insert(@RequestBody @Validated({ActionInsert.class}) UserDTO usersDTO) {
        return usersService.insert(usersDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody @Validated({ActionUpdate.class}) UserDTO usersDTO) {
        return usersService.update(usersDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        usersService.delete(id);
    }
}