package com.personalgarage.service.common.interfaces.errors;

import com.personalgarage.service.base.errors.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ExceptionData;

public final class ApplicationErrors {

    public static final ExceptionData INTERNAL_ERROR = new ExceptionData(ErrorCodeBases.APPLICATION, 1, "Internal error");
    public static final ExceptionData INCORRECT_ARGUMENTS = new ExceptionData(ErrorCodeBases.APPLICATION, 2, "Incorrect arguments provided");

    private ApplicationErrors(){
    }
}
