package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends MongoRepository<Transactions, String> {
}