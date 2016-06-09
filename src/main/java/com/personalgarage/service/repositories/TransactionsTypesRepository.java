package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.TransactionsTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsTypesRepository
        extends MongoRepository<TransactionsTypes, String> {
}