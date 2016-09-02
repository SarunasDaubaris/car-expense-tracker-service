package com.personalgarage.service.domain.transactions.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionsTypesConst {

    FUEL("1", "FUEL"),
    INSURANCE("2", "INSURANCE"),
    TYRES("3", "TYRES"),
    REGULAR_MAINTENANCE("4", "REGULAR MAINTENANCE"),
    DEFECT_REPAIRS("5", "DEFECT REPAIRS"),
    AFTERMARKET_IMPROVEMENTS("6", "AFTERMARKET IMPROVEMENTS"),
    OTHER("7", "OTHER");

    private final String id;
    private final String value;

    TransactionsTypesConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static TransactionsTypesConst forId(String id) {
        for(TransactionsTypesConst cnst : TransactionsTypesConst.values()) {
            if(cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid TransactionsTypesConst ID: " + id);
    }

    @JsonValue
    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}