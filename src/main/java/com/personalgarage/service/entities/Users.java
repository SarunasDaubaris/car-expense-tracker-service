package com.personalgarage.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public final class Users {

    @Id
    private String id;
    private String username;
    private String usersTypes;

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

    public String getUsersTypes() {
        return usersTypes;
    }

    public void setUsersTypes(String usersTypes) {
        this.usersTypes = usersTypes;
    }
}