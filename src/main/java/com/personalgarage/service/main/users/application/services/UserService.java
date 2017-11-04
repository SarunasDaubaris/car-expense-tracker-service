package com.personalgarage.service.main.users.application.services;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.users.application.components.UserServiceModelMapper;
import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;
import com.personalgarage.service.main.users.interfaces.errors.UsersErrors;
import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
    public Long registerUser(UserCredentialsDTO userCredentialsDTO) throws ApplicationServiceException {
        if (StringUtils.isBlank(userCredentialsDTO.getUsername())) {
            throw new ApplicationServiceException(UsersErrors.USERNAME_EMPTY);
        }
        if (StringUtils.isBlank(userCredentialsDTO.getPassword())) {
            throw new ApplicationServiceException(UsersErrors.PASSWORD_EMPTY);
        }
        if (this.userRepository.existsByUsername(userCredentialsDTO.getUsername())) {
            throw new ApplicationServiceException(UsersErrors.USERNAME_TAKEN);
        }

        ApplicationUser user = new ApplicationUser();
        user.setUsername(userCredentialsDTO.getUsername());
        user.setPassword(this.bCryptPasswordEncoder.encode(userCredentialsDTO.getPassword()));
        user.setCreatedDate(DateTime.now(DateTimeZone.UTC));
        user.setUserState(UserStateConst.NEW);
        user.setUserType(UserTypeConst.BASIC);

        this.userRepository.save(user);

        return user.getId();
    }
}