package com.personalgarage.service.api.domain.users.application.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.base.application.interfaces.IRestController;

public interface IUserController extends IRestController {

    UserDTO get(String id);

    UserDTO insert(UserDTO usersDTO);

    UserDTO update(UserDTO usersDTO);

    void delete(String id);
}