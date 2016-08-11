package com.personalgarage.service.controllers;

import com.personalgarage.service.base.controllers.BaseRestController;
import com.personalgarage.service.controllers.interfaces.IUsersController;
import com.personalgarage.service.dto.UsersDTO;
import com.personalgarage.service.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class UsersController extends BaseRestController implements IUsersController {

    private IUsersService usersService;

    public UsersController() {}

    @Autowired
    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UsersDTO get(@PathVariable("id") String id) {
        return usersService.get(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersDTO insert(@RequestBody UsersDTO usersDTO) {
        return usersService.insert(usersDTO);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UsersDTO update(@RequestBody UsersDTO usersDTO) {
        return usersService.update(usersDTO);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        usersService.delete(id);
    }
}