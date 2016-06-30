package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public final class UsersDTO extends BaseDTO {

    private String username;
    private String usersTypes;

    public UsersDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersTypes() {
        return usersTypes;
    }

    public void setUsersTypes(String usersTypes) {
        this.usersTypes = usersTypes;
    }
}