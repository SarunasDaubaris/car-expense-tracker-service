package com.personalgarage.service.api.domain.users.application;

import com.personalgarage.service.api.domain.users.application.services.UserService;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return userService.get(id);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO insert(@RequestBody @Validated({ActionInsert.class}) UserDTO userDTO) {
        return userService.insert(userDTO);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody @Validated({ActionUpdate.class}) UserDTO userDTO) {
        return userService.update(userDTO);
    }
}