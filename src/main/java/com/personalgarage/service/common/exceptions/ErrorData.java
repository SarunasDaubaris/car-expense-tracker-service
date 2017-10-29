package com.personalgarage.service.common.exceptions;

public class ErrorData {

    private ErrorCodeBases codeBase;
    private final Integer code;
    private final String message;

    public ErrorData(ErrorCodeBases codeBase, Integer code, String message) {
        this.codeBase = codeBase;
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return codeBase.getCodeBase() + code;
    }

    public String getMessage() {
        return message;
    }
}