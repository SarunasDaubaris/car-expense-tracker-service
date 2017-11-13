package com.personalgarage.service.main.cars.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class CarsErrors {

    public static final ErrorData LICENCE_PLATE_BLANK = new ErrorData(ErrorCodeBases.CARS, 1, "licencePlate is blank");
    public static final ErrorData MAKE_BLANK = new ErrorData(ErrorCodeBases.CARS, 2, "make is blank");
    public static final ErrorData MODEL_BLANK = new ErrorData(ErrorCodeBases.CARS, 3, "model is blank");
    public static final ErrorData MANUFACTURE_YEAR_INVALID = new ErrorData(ErrorCodeBases.CARS, 4, "manufactureYear is invalid");

    private CarsErrors() {
    }
}