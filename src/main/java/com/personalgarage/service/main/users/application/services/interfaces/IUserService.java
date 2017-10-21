package com.personalgarage.service.main.users.application.services.interfaces;

import com.personalgarage.service.interfaces.main.users.dtos.UserCredentialsDTO;

public interface IUserService {

    Long registerUser(UserCredentialsDTO userCredentialsDTO);
}