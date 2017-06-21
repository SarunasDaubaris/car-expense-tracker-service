package com.personalgarage.service.api.domain.transactions.persistence.entities;

import com.personalgarage.service.api.domain.transactions.data.constants.TransactionsTypesConst;
import com.personalgarage.service.base.persistence.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
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