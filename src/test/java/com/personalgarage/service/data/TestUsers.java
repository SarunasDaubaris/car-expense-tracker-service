package com.personalgarage.service.data;

import com.personalgarage.service.api.domain.users.data.constants.UserStateConst;
import com.personalgarage.service.api.domain.users.data.constants.UserTypeConst;

public enum TestUsers {

    USER_1("1", "sarunas.d@mail.com", UserStateConst.ACTIVE, UserTypeConst.BASIC);

    private final String id;
    private final String username;
    private final UserStateConst usersStates;
    private final UserTypeConst usersTypes;

    TestUsers(String id, String username, UserStateConst usersStates, UserTypeConst usersTypes) {
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

    public UserStateConst getUsersStates() {
        return usersStates;
    }

    public UserTypeConst getUsersTypes() {
        return usersTypes;
    }
}