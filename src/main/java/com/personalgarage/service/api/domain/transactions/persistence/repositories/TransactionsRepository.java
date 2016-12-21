package com.personalgarage.service.api.domain.transactions.persistence.repositories;

import com.personalgarage.service.base.persistence.repositories.IRepository;
import com.personalgarage.service.api.domain.transactions.persistence.entities.Transactions;

public interface TransactionsRepository extends IRepository<Transactions, String> {
}