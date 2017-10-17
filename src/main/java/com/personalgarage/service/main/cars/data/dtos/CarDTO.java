package com.personalgarage.service.main.cars.data.dtos;

import com.personalgarage.service.main.cars.data.constants.FuelTypeConst;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CarDTO {

    @NotNull(message = "Id cannot be null", groups = {ActionUpdate.class})
    private Long id;

    @NotNull(message = "UserId cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private Long userId;

    @NotNull(message = "FuelType cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private FuelTypeConst fuelType;

    @NotNull(message = "LicencePlate cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private String licencePlate;

    @NotBlank(message = "Make cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private String make;

    @NotBlank(message = "Model cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private String model;

    @NotNull(message = "ManufactureYear cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private Integer manufactureYear;
}