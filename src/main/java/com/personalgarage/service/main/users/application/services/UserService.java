package com.personalgarage.service.main.users.application.services;

import com.personalgarage.service.main.users.application.components.UserServiceModelMapper;
import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    private UserServiceModelMapper userServiceModelMapper;
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private UserService() {
    }

    @Autowired
    private UserService(UserServiceModelMapper userServiceModelMapper, UserRepository userRepository) {
        this.userServiceModelMapper = userServiceModelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Long registerUser(UserCredentialsDTO userCredentialsDTO) {
        if (this.userRepository.findByUsername(userCredentialsDTO.getUsername()) != null) {
            throw new IllegalArgumentException("Username is already taken");
        }

        com.personalgarage.service.main.users.persistence.entities.User user = createNewUser(userCredentialsDTO);
        this.userRepository.save(user);

        return user.getId();
    }

    private com.personalgarage.service.main.users.persistence.entities.User createNewUser(UserCredentialsDTO userCredentialsDTO) {
        com.personalgarage.service.main.users.persistence.entities.User user =
                new com.personalgarage.service.main.users.persistence.entities.User();

        user.setUsername(userCredentialsDTO.getUsername());
        user.setPassword(this.bCryptPasswordEncoder.encode(userCredentialsDTO.getPassword()));
        user.setUserState(UserStateConst.NEW);
        user.setUserType(UserTypeConst.BASIC);

        return user;
    }
}