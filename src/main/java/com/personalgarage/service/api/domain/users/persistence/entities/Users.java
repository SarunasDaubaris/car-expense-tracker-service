package com.personalgarage.service.api.domain.users.persistence.entities;

import com.personalgarage.service.api.domain.users.data.constants.UsersTypesConst;
import com.personalgarage.service.base.persistence.entities.BaseEntity;
import com.personalgarage.service.api.domain.users.data.constants.UsersStatesConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "users")
public class Users extends BaseEntity {

    private String username;
    private UsersStatesConst usersStates;
    private UsersTypesConst usersTypes;
    private List<UsersSettings> usersSettings;
}