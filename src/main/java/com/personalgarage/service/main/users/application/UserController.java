package com.personalgarage.service.main.users.application;

import com.personalgarage.service.interfaces.common.validation.groups.ActionInsert;
import com.personalgarage.service.interfaces.common.validation.groups.ActionUpdate;
import com.personalgarage.service.interfaces.main.users.dtos.UserDTO;
import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(@Qualifier("userService") IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return userService.get(id);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO insert(@RequestBody @Validated({ActionInsert.class}) UserDTO userDTO) {
        return userService.insert(userDTO);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody @Validated({ActionUpdate.class}) UserDTO userDTO) {
        return userService.update(userDTO);
    }
}