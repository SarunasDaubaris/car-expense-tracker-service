package com.personalgarage.service.api.domain.users.application;

import com.personalgarage.service.api.domain.users.application.services.interfaces.IUserService;
import com.personalgarage.service.base.application.BaseRestController;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import com.personalgarage.service.api.domain.users.application.interfaces.IUserController;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RequestMapping("/users")
public class UserController extends BaseRestController implements IUserController {

    private IUserService userService;

    public UserController() {}

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return userService.get(id);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO insert(@RequestBody @Validated({ActionInsert.class}) UserDTO userDTO) {
        return userService.insert(userDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody @Validated({ActionUpdate.class}) UserDTO userDTO) {
        return userService.update(userDTO);
    }
}