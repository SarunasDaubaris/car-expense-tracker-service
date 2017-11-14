package com.personalgarage.service.main.users.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;
import com.personalgarage.service.main.users.interfaces.errors.UsersErrors;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserRequest;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserResponse;
import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserTask extends ServiceTask<RegisterUserRequest, RegisterUserResponse> {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public RegisterUserTask(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse processDirectly(RegisterUserRequest request) {
        RegisterUserResponse response = new RegisterUserResponse();

        UserCredentialsDTO userCredentialsDTO = Validate.notNull(request.userCredentialsDTO, "userCredentialsDTO is null");

        if (StringUtils.isBlank(userCredentialsDTO.getUsername())) {
            throw new ApplicationServiceException(UsersErrors.USERNAME_EMPTY);
        }
        if (StringUtils.isBlank(userCredentialsDTO.getPassword())) {
            throw new ApplicationServiceException(UsersErrors.PASSWORD_EMPTY);
        }
        if (userRepository.existsByUsername(userCredentialsDTO.getUsername())) {
            throw new ApplicationServiceException(UsersErrors.USERNAME_TAKEN);
        }

        ApplicationUser user = new ApplicationUser();
        user.setUsername(userCredentialsDTO.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userCredentialsDTO.getPassword()));
        user.setCreatedDate(DateTime.now(DateTimeZone.UTC));
        user.setUserState(UserStateConst.NEW);
        user.setUserType(UserTypeConst.BASIC);

        userRepository.save(user);

        response.userId = user.getId();
        return response;
    }
}