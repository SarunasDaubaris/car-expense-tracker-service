package com.personalgarage.service.security.services;

import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TransactionAccessService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionAccessService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    public boolean isAccessibleWithTransactionId(Authentication authentication, Long transactionId) {
        if (authentication != null && transactionId != null) {
            ApplicationUser applicationUser = userRepository.findByUsername(authentication.getName());
            Transaction transaction = transactionRepository.findOne(transactionId);
            return applicationUser != null && transaction != null && transaction.getUser().getId().equals(applicationUser.getId());
        }
        return false;
    }
}