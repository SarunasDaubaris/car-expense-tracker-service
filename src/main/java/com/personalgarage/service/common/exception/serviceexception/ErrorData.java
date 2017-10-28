package com.personalgarage.service.common.exception.serviceexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ErrorData {

    private ErrorCodeBases codeBase;
    private final Integer code;

    @Getter
    private final String message;

    public Integer getCode() {
        return codeBase.getCodeBase() + code;
    }
}