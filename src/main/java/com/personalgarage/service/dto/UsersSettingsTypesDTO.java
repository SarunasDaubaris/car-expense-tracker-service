package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public class UsersSettingsTypesDTO extends BaseDTO {

    private String title;
    private String value;

    public UsersSettingsTypesDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}