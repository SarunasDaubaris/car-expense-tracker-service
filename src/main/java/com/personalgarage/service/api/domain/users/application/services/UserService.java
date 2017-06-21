package com.personalgarage.service.api.domain.users.application.services;

import com.personalgarage.service.api.domain.users.application.services.interfaces.IUserService;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.base.application.services.BaseRestService;

public class UserService extends BaseRestService implements IUserService {

    @Override
    public UserDTO get(String id) {
        return null;
    }

    @Override
    public UserDTO insert(UserDTO usersDTO) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO usersDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}