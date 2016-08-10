package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public class UsersSettingsDTO extends BaseDTO {

    private UsersSettingsTypesDTO usersSettingsTypes;

    public UsersSettingsDTO() {}

    public UsersSettingsTypesDTO getUsersSettingsTypes() {
        return usersSettingsTypes;
    }

    public void setUsersSettingsTypes(UsersSettingsTypesDTO usersSettingsTypes) {
        this.usersSettingsTypes = usersSettingsTypes;
    }
}