package com.personalgarage.service.main.cars.interfaces.errors;

import com.personalgarage.service.base.errors.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ExceptionData;

public final class CarsErrors {

    public static final ExceptionData LICENCE_PLATE_BLANK = new ExceptionData(ErrorCodeBases.CARS, 1, "licencePlate is blank");
    public static final ExceptionData MAKE_BLANK = new ExceptionData(ErrorCodeBases.CARS, 2, "make is blank");
    public static final ExceptionData MODEL_BLANK = new ExceptionData(ErrorCodeBases.CARS, 3, "model is blank");
    public static final ExceptionData MANUFACTURE_YEAR_INVALID = new ExceptionData(ErrorCodeBases.CARS, 4, "manufactureYear is invalid");

    private CarsErrors() {
    }
}