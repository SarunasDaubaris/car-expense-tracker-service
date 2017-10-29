package com.personalgarage.service.main.cars.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;
import lombok.Getter;

@Getter
public class CarsErrors {

    private final ErrorData USER_ID_INVALID = new ErrorData(ErrorCodeBases.CARS, 1, "userId is invalid");
}