package com.personalgarage.service.common.exception.serviceexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCodeBases {

    CARS(1000),
    TRANSACTIONS(2000),
    USERS(3000);

    @Getter
    private final Integer codeBase;
}