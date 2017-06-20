package com.personalgarage.service.api.domain.users.application.services;

import com.personalgarage.service.api.domain.users.application.services.interfaces.IUsersService;
import com.personalgarage.service.api.domain.users.data.dtos.UsersDTO;
import com.personalgarage.service.base.application.services.BaseRestService;

public class UsersService extends BaseRestService implements IUsersService {

    @Override
    public UsersDTO get(String id) {
        return null;
    }

    @Override
    public UsersDTO insert(UsersDTO usersDTO) {
        return null;
    }

    @Override
    public UsersDTO update(UsersDTO usersDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}