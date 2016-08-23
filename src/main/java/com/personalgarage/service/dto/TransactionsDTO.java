package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.constants.TransactionsTypesConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TransactionsDTO extends BaseDTO {

    @NotBlank(message = "UserId cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String userId;

    @NotBlank(message = "CarId cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String carId;

    @NotNull(message = "TransactionsTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private TransactionsTypesConst transactionsTypes;

    @NotNull(message = "CreatedTime cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private Long createdTime;

    @NotNull(message = "LastUpdatedTime cannot be null", groups = {ActionUpdate.class})
    private Long lastUpdateTime;

    @NotNull(message = "Amount cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private BigDecimal amount;

    private String description;
}