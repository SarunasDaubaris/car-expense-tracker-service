package com.personalgarage.service.main.users.application.services.interfaces;

import com.personalgarage.service.interfaces.main.users.dtos.UserDTO;

public interface IUserService {
    UserDTO get(Long id);

    UserDTO insert(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);
}