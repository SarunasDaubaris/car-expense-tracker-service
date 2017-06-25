package com.personalgarage.service.api.domain.transactions.persistence.entities;


import com.personalgarage.service.api.domain.cars.persistence.entities.Car;
import com.personalgarage.service.api.domain.transactions.data.constants.TransactionTypeConst;
import com.personalgarage.service.api.domain.users.persistence.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.ORDINAL)
    private TransactionTypeConst transactionType;

    @Column(name = "created_time")
    private DateTime createdTime;

    @Column(name = "last_update_time")
    private DateTime lastUpdateTime;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;
}