package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public class UsersStatesDTO extends BaseDTO {

    private String value;

    public UsersStatesDTO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}