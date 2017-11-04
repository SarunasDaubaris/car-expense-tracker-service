package com.personalgarage.service.common.interfaces;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class ApplicationErrors {

    private ApplicationErrors(){
    }

    public static final ErrorData INTERNAL_ERROR = new ErrorData(ErrorCodeBases.APPLICATION, 1, "Internal error");
    public static final ErrorData INCORRECT_ARGUMENTS = new ErrorData(ErrorCodeBases.APPLICATION, 2, "Incorrect arguments provided");
}
