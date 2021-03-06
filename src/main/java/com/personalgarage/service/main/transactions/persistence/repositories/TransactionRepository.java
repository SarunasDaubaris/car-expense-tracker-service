package com.personalgarage.service.main.transactions.persistence.repositories;

import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByCarId(Long userId);
}