package com.personalgarage.service.api.domain.users.application.services;

import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.api.domain.users.persistence.entities.User;
import com.personalgarage.service.api.domain.users.persistence.repositories.UserRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseRestService {

    private final DomainDataMapper<UserDTO, User> domainDataMapper = new DomainDataMapper<>();

    private UserRepository userRepository;

    private UserService() {
    }

    @Autowired
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO get(Long id) {
        return domainDataMapper.convertToDto(userRepository.findOne(id));
    }

    public UserDTO insert(UserDTO userDTO) {
        return domainDataMapper.convertToDto(userRepository.save(domainDataMapper.convertToEntity(userDTO)));
    }

    public UserDTO update(UserDTO userDTO) {
        return domainDataMapper.convertToDto(userRepository.save(domainDataMapper.convertToEntity(userDTO)));
    }
}