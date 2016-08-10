package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public class UsersTypesDTO extends BaseDTO {

    private String value;

    public UsersTypesDTO() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}