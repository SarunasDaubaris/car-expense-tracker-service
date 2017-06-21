package com.personalgarage.service.api.domain.transactions.application.interfaces;

import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ITransactionController {

    TransactionDTO get(Long id);

    TransactionDTO insert(TransactionDTO transactionDTO);

    TransactionDTO update(TransactionDTO transactionDTO);

    void delete(Long id);
}