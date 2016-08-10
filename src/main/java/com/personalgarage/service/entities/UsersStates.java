package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersStates")
public class UsersStates extends BaseEntity {

    private String value;

    public UsersStates() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}