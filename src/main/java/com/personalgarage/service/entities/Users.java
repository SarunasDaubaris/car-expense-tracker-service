package com.personalgarage.service.entities;

import com.personalgarage.service.constants.UsersStatesConst;
import com.personalgarage.service.constants.UsersTypesConst;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class Users {

    private String username;
    private UsersStatesConst usersStates;
    private UsersTypesConst usersTypes;
    private List<UsersSettings> usersSettings;
}