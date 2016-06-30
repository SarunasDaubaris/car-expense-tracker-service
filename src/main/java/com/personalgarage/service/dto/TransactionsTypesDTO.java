package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public final class TransactionsTypesDTO extends BaseDTO {

    private String title;

    public TransactionsTypesDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}