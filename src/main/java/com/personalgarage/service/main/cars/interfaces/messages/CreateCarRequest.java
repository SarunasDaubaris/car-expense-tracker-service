package com.personalgarage.service.main.cars.interfaces.messages;

import com.personalgarage.service.base.messages.TaskRequest;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;

public class CreateCarRequest extends TaskRequest {

    public CarDTO carDTO;
}