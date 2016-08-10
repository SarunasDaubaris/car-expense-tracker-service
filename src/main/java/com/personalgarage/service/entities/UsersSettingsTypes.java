package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersSettingsTypes")
public class UsersSettingsTypes extends BaseEntity {

    private String value;

    public UsersSettingsTypes() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}