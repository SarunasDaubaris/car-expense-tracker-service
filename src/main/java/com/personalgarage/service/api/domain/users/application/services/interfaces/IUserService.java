package com.personalgarage.service.api.domain.users.application.services.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    UserDTO get(String id);

    UserDTO insert(UserDTO usersDTO);

    UserDTO update(UserDTO usersDTO);

    void delete(String id);
}