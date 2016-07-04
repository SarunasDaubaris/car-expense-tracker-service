package com.personalgarage.service.services;

import com.personalgarage.service.base.services.DTOBaseService;
import com.personalgarage.service.dto.UsersDTO;
import com.personalgarage.service.entities.Users;

public class UsersService extends DTOBaseService<UsersDTO, Users> {

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

    @Override
    protected UsersDTO convertToDto(Users users) {
        return null;
    }

    @Override
    protected Users convertToEntity(UsersDTO usersDTO) {
        return null;
    }
}