package com.personalgarage.service.common.application;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.common.interfaces.errors.ApplicationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ApplicationErrors.INTERNAL_ERROR, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ApplicationErrors.INCORRECT_ARGUMENTS, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ApplicationServiceException.class})
    public ResponseEntity<Object> handleApplicationServiceException(RuntimeException ex, WebRequest request) {
        ApplicationServiceException applicationServiceException = (ApplicationServiceException) ex;
        return handleExceptionInternal(ex, applicationServiceException.getExceptionData(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}