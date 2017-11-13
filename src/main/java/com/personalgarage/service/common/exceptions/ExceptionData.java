package com.personalgarage.service.common.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.personalgarage.service.base.errors.ErrorCodeBases;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ExceptionData {

    @JsonIgnore
    private final Integer code;

    @JsonIgnore
    private final String message;

    public ExceptionData(ErrorCodeBases codeBase, Integer codeNumber, String message) {
        this.code = codeBase.getCodeBase() + codeNumber;
        this.message = message;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}