package com.personalgarage.service.main.users.application.services;

import com.personalgarage.service.base.application.ServiceTaskCreator;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.users.application.services.interfaces.IUserService;
import com.personalgarage.service.main.users.application.tasks.RegisterUserTask;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserRequest;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    private final ServiceTaskCreator serviceTaskCreator;

    @Autowired
    public UserService(ServiceTaskCreator serviceTaskCreator) {
        this.serviceTaskCreator = serviceTaskCreator;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(RegisterUserTask.class).processInTransaction(request);
    }
}