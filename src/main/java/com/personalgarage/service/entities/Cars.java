package com.personalgarage.service.entities;

import com.personalgarage.service.constants.FuelTypesConst;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "cars")
public class Cars {

    private String owner;
    private String make;
    private String model;
    private Integer year;
    private FuelTypesConst fuelTypes;
    private String licencePlate;
}