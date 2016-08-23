package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import com.personalgarage.service.constants.TransactionsTypesConst;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection = "transactions")
public class Transactions extends BaseEntity {

    private String carId;
    private String userId;
    private TransactionsTypesConst transactionsTypes;
    private Long createdTime;
    private Long lastUpdatedTime;
    private BigDecimal amount;
    private String description;
}