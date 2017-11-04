package com.personalgarage.service.main.cars.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class CarsErrors {

    private CarsErrors() {
    }

    public static final ErrorData USER_ID_INVALID = new ErrorData(ErrorCodeBases.CARS, 1, "userId is invalid");
}