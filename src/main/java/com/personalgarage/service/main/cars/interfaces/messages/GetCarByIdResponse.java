package com.personalgarage.service.main.cars.interfaces.messages;

import com.personalgarage.service.base.messages.TaskResponse;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;

public class GetCarByIdResponse extends TaskResponse {

    public CarDTO carDTO;
}