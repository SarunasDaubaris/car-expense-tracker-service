package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public final class UsersTypesDTO extends BaseDTO {

    private String title;

    public UsersTypesDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}