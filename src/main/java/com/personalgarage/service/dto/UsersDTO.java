package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.entities.UsersSettings;

import java.util.List;

public final class UsersDTO extends BaseDTO {

    private String username;
    private UsersStatesDTO usersStates;
    private UsersTypesDTO usersTypes;
    private List<UsersSettings> usersSettings;

    public UsersDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsersStatesDTO getUsersStates() {
        return usersStates;
    }

    public void setUsersStates(UsersStatesDTO usersStates) {
        this.usersStates = usersStates;
    }

    public UsersTypesDTO getUsersTypes() {
        return usersTypes;
    }

    public void setUsersTypes(UsersTypesDTO usersTypes) {
        this.usersTypes = usersTypes;
    }

    public List<UsersSettings> getUsersSettings() {
        return usersSettings;
    }

    public void setUsersSettings(List<UsersSettings> usersSettings) {
        this.usersSettings = usersSettings;
    }
}