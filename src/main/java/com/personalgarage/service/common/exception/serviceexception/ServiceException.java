package com.personalgarage.service.common.exception.serviceexception;

import lombok.Getter;

public class ServiceException extends RuntimeException {

    @Getter
    private final ErrorData errorData;

    public ServiceException(ErrorData errorData) {
        super();
        this.errorData = errorData;
    }
}