package com.personalgarage.service.common.exceptions;

public enum ErrorCodeBases {

    APPLICATION(10000),
    USERS(20000),
    CARS(30000),
    TRANSACTIONS(40000);

    private final Integer codeBase;

    ErrorCodeBases(Integer codeBase) {
        this.codeBase = codeBase;
    }

    public Integer getCodeBase() {
        return codeBase;
    }
}