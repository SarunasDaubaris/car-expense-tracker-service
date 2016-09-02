package com.personalgarage.service.domain.cars.persistence.entities;

import com.personalgarage.service.base.persistence.entities.BaseEntity;
import com.personalgarage.service.domain.cars.data.constants.FuelTypesConst;
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