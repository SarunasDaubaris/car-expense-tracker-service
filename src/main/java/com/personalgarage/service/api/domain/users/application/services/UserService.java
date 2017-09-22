package com.personalgarage.service.api.domain.users.application.services;

import com.personalgarage.service.api.domain.users.application.components.UserServiceModelMapper;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.api.domain.users.persistence.entities.User;
import com.personalgarage.service.api.domain.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserServiceModelMapper userServiceModelMapper;
    private UserRepository userRepository;

    private UserService() {
    }

    @Autowired
    private UserService(UserServiceModelMapper userServiceModelMapper, UserRepository userRepository) {
        this.userServiceModelMapper = userServiceModelMapper;
        this.userRepository = userRepository;
    }

    public UserDTO get(Long id) {
        return userServiceModelMapper.mapByClass(userRepository.findOne(id), UserDTO.class);
    }

    public UserDTO insert(UserDTO userDTO) {
        User user = userServiceModelMapper.mapByClass(userDTO, User.class);
        return userServiceModelMapper.mapByClass(userRepository.save(user), UserDTO.class);
    }

    public UserDTO update(UserDTO userDTO) {
        User user = userServiceModelMapper.mapByClass(userDTO, User.class);
        return userServiceModelMapper.mapByClass(userRepository.save(user), UserDTO.class);
    }
}