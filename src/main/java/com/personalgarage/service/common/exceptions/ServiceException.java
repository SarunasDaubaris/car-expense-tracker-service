package com.personalgarage.service.common.exceptions;

public class ServiceException extends RuntimeException {

    private final ErrorData errorData;

    public ServiceException(ErrorData errorData) {
        super();
        this.errorData = errorData;
    }

    public ErrorData getErrorData() {
        return errorData;
    }
}