package com.personalgarage.service.domain.users.application.services;

import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.core.DomainDataMapper;
import com.personalgarage.service.domain.users.data.dtos.UsersDTO;
import com.personalgarage.service.domain.users.persistence.entities.Users;
import com.personalgarage.service.domain.users.persistence.repositories.UsersRepository;
import com.personalgarage.service.domain.users.application.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService extends BaseRestService implements IUsersService {

    private UsersRepository usersRepository;
    private DomainDataMapper<UsersDTO, Users> domainDataMapper = new DomainDataMapper<>();

    public UsersService() {}

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDTO get(String id) {
        return domainDataMapper.convertToDto(usersRepository.findOne(id));
    }

    @Override
    public UsersDTO insert(UsersDTO usersDTO) {
        return domainDataMapper.convertToDto(usersRepository.insert(domainDataMapper.convertToEntity(usersDTO)));
    }

    @Override
    public UsersDTO update(UsersDTO usersDTO) {
        return domainDataMapper.convertToDto(usersRepository.save(domainDataMapper.convertToEntity(usersDTO)));
    }

    @Override
    public void delete(String id) {
        usersRepository.delete(id);
    }
}