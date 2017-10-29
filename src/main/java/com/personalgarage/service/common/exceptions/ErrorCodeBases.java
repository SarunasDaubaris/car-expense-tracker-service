package com.personalgarage.service.common.exceptions;

public enum ErrorCodeBases {

    CARS(10000),
    TRANSACTIONS(20000),
    USERS(30000);

    private final Integer codeBase;

    ErrorCodeBases(Integer codeBase) {
        this.codeBase = codeBase;
    }

    public Integer getCodeBase() {
        return codeBase;
    }
}