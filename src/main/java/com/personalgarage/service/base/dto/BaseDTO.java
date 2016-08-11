package com.personalgarage.service.base.dto;

import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;

public abstract class BaseDTO implements IDTO {

    @Null(message = "Id must be null", groups = {ActionInsert.class })
    @NotBlank(message = "Id cannot be blank", groups = { ActionUpdate.class })
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}