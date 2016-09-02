package com.personalgarage.service.data;

import com.personalgarage.service.constants.UsersStatesConst;
import com.personalgarage.service.constants.UsersTypesConst;

public enum TestUsers {

    USER_1("1", "sarunas.d@mail.com", UsersStatesConst.ACTIVE, UsersTypesConst.BASIC);

    private final String id;
    private final String username;
    private final UsersStatesConst usersStates;
    private final UsersTypesConst usersTypes;

    TestUsers(String id, String username, UsersStatesConst usersStates, UsersTypesConst usersTypes) {
        this.id = id;
        this.username = username;
        this.usersStates = usersStates;
        this.usersTypes = usersTypes;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public UsersStatesConst getUsersStates() {
        return usersStates;
    }

    public UsersTypesConst getUsersTypes() {
        return usersTypes;
    }
}