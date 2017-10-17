package com.personalgarage.service.main.users.application.services.interfaces;

import com.personalgarage.service.main.users.data.dtos.UserDTO;

public interface IUserService {
    UserDTO get(Long id);

    UserDTO insert(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);
}
