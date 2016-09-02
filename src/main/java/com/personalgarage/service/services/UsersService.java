package com.personalgarage.service.services;

import com.personalgarage.service.base.services.BaseRestService;
import com.personalgarage.service.base.RestMapper;
import com.personalgarage.service.dto.UsersDTO;
import com.personalgarage.service.entities.Users;
import com.personalgarage.service.repositories.UsersRepository;
import com.personalgarage.service.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService extends BaseRestService implements IUsersService {

    private UsersRepository usersRepository;
    private RestMapper<UsersDTO, Users> restMapper = new RestMapper<>();

    public UsersService() {}

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDTO get(String id) {
        return restMapper.convertToDto(usersRepository.findOne(id));
    }

    @Override
    public UsersDTO insert(UsersDTO usersDTO) {
        return restMapper.convertToDto(usersRepository.insert(restMapper.convertToEntity(usersDTO)));
    }

    @Override
    public UsersDTO update(UsersDTO usersDTO) {
        return restMapper.convertToDto(usersRepository.save(restMapper.convertToEntity(usersDTO)));
    }

    @Override
    public void delete(String id) {
        usersRepository.delete(id);
    }
}