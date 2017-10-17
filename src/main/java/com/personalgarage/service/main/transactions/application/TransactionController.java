package com.personalgarage.service.main.transactions.application;

import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private ITransactionService transactionService;

    public TransactionController() {
    }

    @Autowired
    public TransactionController(@Qualifier("transactionService") ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return transactionService.get(id);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO insert(@RequestBody @Validated({ActionInsert.class}) TransactionDTO transactionDTO) {
        return transactionService.insert(transactionDTO);
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO update(@RequestBody @Validated({ActionUpdate.class}) TransactionDTO transactionDTO) {
        return transactionService.update(transactionDTO);
    }
}