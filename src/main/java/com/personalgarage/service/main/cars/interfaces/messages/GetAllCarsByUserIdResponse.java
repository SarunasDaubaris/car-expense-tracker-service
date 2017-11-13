package com.personalgarage.service.main.cars.interfaces.messages;

import com.personalgarage.service.base.messages.TaskResponse;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;

import java.util.List;

public class GetAllCarsByUserIdResponse extends TaskResponse {
    
    public List<CarDTO> carDTOs;
}