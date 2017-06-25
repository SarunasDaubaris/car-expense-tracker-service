package com.personalgarage.service.api.domain.users.application.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IUserController {

    UserDTO get(String id);

    UserDTO insert(UserDTO usersDTO);

    UserDTO update(UserDTO usersDTO);
}