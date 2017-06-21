package com.personalgarage.service.api.domain.users.application.services.interfaces;

import com.personalgarage.service.base.application.services.interfaces.IRestService;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;

public interface IUserService extends IRestService {

    UserDTO get(String id);

    UserDTO insert(UserDTO usersDTO);

    UserDTO update(UserDTO usersDTO);

    void delete(String id);
}