package com.personalgarage.service.main.users.application;

import com.personalgarage.service.interfaces.main.users.dtos.UserCredentialsDTO;
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

    @PostMapping(value = "/register", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Long registerUser(@RequestBody @Validated @NotNull UserCredentialsDTO userCredentialsDTO) {
        return this.userService.registerUser(userCredentialsDTO);
    }
}