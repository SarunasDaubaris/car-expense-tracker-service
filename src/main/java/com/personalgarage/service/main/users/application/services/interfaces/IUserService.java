package com.personalgarage.service.main.users.application.services.interfaces;


import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserRequest;
import com.personalgarage.service.main.users.interfaces.messages.RegisterUserResponse;

public interface IUserService {

    RegisterUserResponse registerUser(RegisterUserRequest request) throws ApplicationServiceException;
}