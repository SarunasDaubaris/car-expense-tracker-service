package com.personalgarage.service.main.users.application.services.interfaces;


import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;

public interface IUserService {

    Long registerUser(UserCredentialsDTO userCredentialsDTO);
}