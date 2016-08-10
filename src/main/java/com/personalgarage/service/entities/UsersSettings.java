package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersSettings")
public class UsersSettings extends BaseEntity {

    private UsersSettingsTypes usersSettingsTypes;

    public UsersSettings() {}

    public UsersSettingsTypes getUsersSettingsTypes() {
        return usersSettingsTypes;
    }

    public void setUsersSettingsTypes(UsersSettingsTypes usersSettingsTypes) {
        this.usersSettingsTypes = usersSettingsTypes;
    }
}