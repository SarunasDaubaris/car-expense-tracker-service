package com.personalgarage.service.api.domain.users.application.services.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;

public interface IUserService {
    UserDTO get(Long id);

    UserDTO insert(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);
}
