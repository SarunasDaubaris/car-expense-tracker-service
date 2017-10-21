package com.personalgarage.service.main.users.application;

import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.OK)
    public String register() {
        return "trying to register";
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public String login() {
        return "trying to login";
    }
}