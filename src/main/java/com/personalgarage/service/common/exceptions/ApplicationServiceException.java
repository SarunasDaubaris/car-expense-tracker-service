package com.personalgarage.service.common.exceptions;

public class ApplicationServiceException extends RuntimeException {

    private final ExceptionData errorData;

    public ApplicationServiceException(ExceptionData errorData) {
        super();
        this.errorData = errorData;
    }

    public ExceptionData getExceptionData() {
        return errorData;
    }
}