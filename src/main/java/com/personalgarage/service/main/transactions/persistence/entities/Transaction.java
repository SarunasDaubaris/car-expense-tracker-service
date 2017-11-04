package com.personalgarage.service.main.transactions.persistence.entities;

import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.transactions.interfaces.constants.TransactionTypeConst;
import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transactions")
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
    private ApplicationUser user;

    @Column(name = "transaction_type")
    private Short transactionTypeId;

    @Column(name = "created_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
                    @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")})
    private DateTime createdDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    public TransactionTypeConst getTransactionType() {
        return TransactionTypeConst.forId(transactionTypeId);
    }

    public void setTransactionType(TransactionTypeConst transactionType) {
        this.transactionTypeId = transactionType.getId();
    }
}