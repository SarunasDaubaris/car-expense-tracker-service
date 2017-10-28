package com.personalgarage.service.main.transactions.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personalgarage.service.main.transactions.interfaces.constants.TransactionTypeConst;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TransactionDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("carId")
    private Long carId;

    @JsonProperty("transactionType")
    private TransactionTypeConst transactionType;

    @JsonProperty("createdTime")
    private DateTime createdTime;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("description")
    private String description;
}