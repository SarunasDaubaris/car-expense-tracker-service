package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactionsTypes")
public class TransactionsTypes extends BaseEntity {

    private String value;

    public TransactionsTypes() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}