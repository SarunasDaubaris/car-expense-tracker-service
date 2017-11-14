package com.personalgarage.service.main.users.interfaces.messages;

import com.personalgarage.service.base.messages.TaskRequest;
import com.personalgarage.service.main.users.interfaces.dtos.UserCredentialsDTO;

public class RegisterUserRequest extends TaskRequest {

    public UserCredentialsDTO userCredentialsDTO;
}