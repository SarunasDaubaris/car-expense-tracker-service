package com.personalgarage.service.data;

import com.personalgarage.service.interfaces.main.users.constants.UserStateConst;
import com.personalgarage.service.interfaces.main.users.constants.UserTypeConst;

public enum TestUsers {

    USER_1(1L, "sarunas.d@mail.com", UserStateConst.ACTIVE, UserTypeConst.BASIC);

    private final Long id;
    private final String username;
    private final UserStateConst userState;
    private final UserTypeConst userType;

    TestUsers(Long id, String username, UserStateConst userState, UserTypeConst userType) {
        this.id = id;
        this.username = username;
        this.userState = userState;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public UserStateConst getUserState() {
        return userState;
    }

    public UserTypeConst getUserType() {
        return userType;
    }
}