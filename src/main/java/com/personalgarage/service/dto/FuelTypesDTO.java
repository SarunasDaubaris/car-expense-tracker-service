package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

import javax.validation.constraints.NotNull;

public class FuelTypesDTO extends BaseDTO {

    @NotNull
    private String value;

    public FuelTypesDTO() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}