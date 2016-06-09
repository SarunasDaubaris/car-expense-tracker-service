package com.personalgarage.service.dto;

public final class UsersDTO {

    private String id;
    private String username;
    private String usersTypes;

    public UsersDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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