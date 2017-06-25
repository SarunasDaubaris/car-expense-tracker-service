package com.personalgarage.service.api.domain.users.application.services;

import com.personalgarage.service.api.domain.users.application.services.interfaces.IUserService;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.api.domain.users.persistence.entities.User;
import com.personalgarage.service.api.domain.users.persistence.repositories.UserRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService extends BaseRestService implements IUserService {

    private final DomainDataMapper<UserDTO, User> domainDataMapper = new DomainDataMapper<>();

    private UserRepository userRepository;

    private UserService() {
    }

    @Autowired
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO get(Long id) {
        return domainDataMapper.convertToDto(userRepository.findOne(id));
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {
        return domainDataMapper.convertToDto(userRepository.save(domainDataMapper.convertToEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return domainDataMapper.convertToDto(userRepository.save(domainDataMapper.convertToEntity(userDTO)));
    }
}