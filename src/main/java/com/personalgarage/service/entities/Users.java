package com.personalgarage.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public final class Users {

    @Id
    private String id;
    private String username;
    private UsersTypes usersTypes;
    private List<UsersSettings> usersSettings;

    public Users() {}

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