package com.personalgarage.service.common.exceptions;

public enum ErrorCodeBases {

    CARS(1000),
    TRANSACTIONS(2000),
    USERS(3000);

    private final Integer codeBase;

    ErrorCodeBases(Integer codeBase) {
        this.codeBase = codeBase;
    }

    public Integer getCodeBase() {
        return codeBase;
    }
}