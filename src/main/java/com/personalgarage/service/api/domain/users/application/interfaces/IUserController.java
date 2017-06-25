package com.personalgarage.service.api.domain.users.application.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IUserController {

    UserDTO get(Long id);

    UserDTO insert(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);
}