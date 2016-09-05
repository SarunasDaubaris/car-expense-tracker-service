package com.personalgarage.service.domain.users.application.interfaces;

import com.personalgarage.service.base.application.interfaces.IRestController;
import com.personalgarage.service.domain.users.data.dtos.UsersDTO;

public interface IUsersController extends IRestController {

    UsersDTO get(String id);

    UsersDTO insert(UsersDTO usersDTO);

    UsersDTO update(UsersDTO usersDTO);

    void delete(String id);
}