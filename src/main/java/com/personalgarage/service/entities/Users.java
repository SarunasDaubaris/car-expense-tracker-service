package com.personalgarage.service.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public final class Users {

    private String username;
    private UsersTypes usersTypes;
    private List<UsersSettings> usersSettings;

    public Users() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsersTypes getUsersTypes() {
        return usersTypes;
    }

    public void setUsersTypes(UsersTypes usersTypes) {
        this.usersTypes = usersTypes;
    }

    public List<UsersSettings> getUsersSettings() {
        return usersSettings;
    }

    public void setUsersSettings(List<UsersSettings> usersSettings) {
        this.usersSettings = usersSettings;
    }
}