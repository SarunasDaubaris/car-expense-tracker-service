package com.personalgarage.service.main.transactions.data.dtos;

import com.personalgarage.service.main.transactions.data.constants.TransactionTypeConst;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TransactionDTO {

    @NotNull(message = "Id cannot be null", groups = {ActionUpdate.class})
    private Long id;

    @NotNull(message = "UserId cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private Long userId;

    @NotNull(message = "CarId cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private Long carId;

    @NotNull(message = "TransactionType cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private TransactionTypeConst transactionType;

    private DateTime createdTime;

    private DateTime lastUpdateTime;

    @NotNull(message = "Amount cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private BigDecimal amount;

    private String description;
}