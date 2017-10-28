package com.personalgarage.service.main.transactions.interfaces.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionTypeConst {

    FUEL((short) 1, "FUEL"),
    INSURANCE((short) 2, "INSURANCE"),
    TYRES((short) 3, "TYRES"),
    REGULAR_MAINTENANCE((short) 4, "REGULAR MAINTENANCE"),
    DEFECT_REPAIRS((short) 5, "DEFECT REPAIRS"),
    AFTERMARKET_IMPROVEMENTS((short) 6, "AFTERMARKET IMPROVEMENTS"),
    OTHER((short) 7, "OTHER");

    private final Short id;
    private final String value;

    TransactionTypeConst(Short id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static TransactionTypeConst forId(Short id) {
        for (TransactionTypeConst cnst : TransactionTypeConst.values()) {
            if (cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid TransactionTypeConst ID: " + id);
    }

    @JsonValue
    public Short getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}