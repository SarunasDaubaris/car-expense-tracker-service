package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.constants.FuelTypesConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CarsDTO extends BaseDTO {

    @NotBlank(message = "UserId cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String userId;

    @NotBlank(message = "Make cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String make;

    @NotBlank(message = "Model cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String model;

    @NotNull(message = "Year cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private Integer year;

    @NotNull(message = "FuelTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private FuelTypesConst fuelTypes;

    private String licencePlate;
}