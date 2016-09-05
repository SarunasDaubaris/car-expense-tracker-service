package com.personalgarage.service.domain.users.application.services.interfaces;

import com.personalgarage.service.base.application.services.interfaces.IRestService;
import com.personalgarage.service.domain.users.data.dtos.UsersDTO;

public interface IUsersService extends IRestService {

    UsersDTO get(String id);

    UsersDTO insert(UsersDTO usersDTO);

    UsersDTO update(UsersDTO usersDTO);

    void delete(String id);
}