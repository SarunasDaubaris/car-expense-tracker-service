package com.personalgarage.service.common.exceptions;

public class ApplicationServiceException extends RuntimeException {

    private final ErrorData errorData;

    public ApplicationServiceException(ErrorData errorData) {
        super();
        this.errorData = errorData;
    }

    public ErrorData getErrorData() {
        return errorData;
    }
}