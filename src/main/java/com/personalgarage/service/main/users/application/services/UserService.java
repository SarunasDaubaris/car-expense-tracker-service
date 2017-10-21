package com.personalgarage.service.main.users.application.services;

import com.personalgarage.service.main.users.application.components.UserServiceModelMapper;
import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    private UserServiceModelMapper userServiceModelMapper;
    private UserRepository userRepository;

    private UserService() {
    }

    @Autowired
    private UserService(UserServiceModelMapper userServiceModelMapper, UserRepository userRepository) {
        this.userServiceModelMapper = userServiceModelMapper;
        this.userRepository = userRepository;
    }
}