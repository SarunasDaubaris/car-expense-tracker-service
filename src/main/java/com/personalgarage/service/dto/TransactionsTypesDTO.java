package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public final class TransactionsTypesDTO extends BaseDTO {

    private String value;

    public TransactionsTypesDTO() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}