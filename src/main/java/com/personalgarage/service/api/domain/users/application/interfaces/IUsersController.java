package com.personalgarage.service.api.domain.users.application.interfaces;

import com.personalgarage.service.api.domain.users.data.dtos.UsersDTO;
import com.personalgarage.service.base.application.interfaces.IRestController;

public interface IUsersController extends IRestController {

    UsersDTO get(String id);

    UsersDTO insert(UsersDTO usersDTO);

    UsersDTO update(UsersDTO usersDTO);

    void delete(String id);
}