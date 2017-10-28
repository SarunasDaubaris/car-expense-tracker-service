package com.personalgarage.service.main.cars.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personalgarage.service.main.cars.interfaces.constants.FuelTypeConst;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("fuelType")
    private FuelTypeConst fuelType;

    @JsonProperty("licencePlate")
    private String licencePlate;

    @JsonProperty("make")
    private String make;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufactureYear")
    private Integer manufactureYear;
}