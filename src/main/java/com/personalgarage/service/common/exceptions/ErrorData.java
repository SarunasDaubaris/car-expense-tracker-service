package com.personalgarage.service.common.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorData {

    @JsonIgnore
    private ErrorCodeBases codeBase;

    @JsonIgnore
    private final Integer code;

    @JsonIgnore
    private final String message;

    public ErrorData(ErrorCodeBases codeBase, Integer code, String message) {
        this.codeBase = codeBase;
        this.code = code;
        this.message = message;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return codeBase.getCodeBase() + code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}