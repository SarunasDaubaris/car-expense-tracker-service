package com.personalgarage.service.main.cars.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class CarsErrors {

    public static final ErrorData USER_ID_INVALID = new ErrorData(ErrorCodeBases.CARS, 1, "userId is invalid");
    public static final ErrorData FUEL_TYPE_NULL = new ErrorData(ErrorCodeBases.CARS, 2, "fuelType is null");
    public static final ErrorData LICENCE_PLATE_BLANK = new ErrorData(ErrorCodeBases.CARS, 3, "licencePlate is blank");
    public static final ErrorData MAKE_BLANK = new ErrorData(ErrorCodeBases.CARS, 4, "make is blank");
    public static final ErrorData MODEL_BLANK = new ErrorData(ErrorCodeBases.CARS, 5, "model is blank");
    public static final ErrorData MANUFACTURE_YEAR_INVALID = new ErrorData(ErrorCodeBases.CARS, 6, "manufactureYear is invalid");

    private CarsErrors() {
    }
}