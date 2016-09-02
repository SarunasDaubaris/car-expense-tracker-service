package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import com.personalgarage.service.constants.FuelTypesConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "cars")
public class Cars extends BaseEntity {

    private String owner;
    private String make;
    private String model;
    private Integer year;
    private FuelTypesConst fuelTypes;
    private String licencePlate;
}