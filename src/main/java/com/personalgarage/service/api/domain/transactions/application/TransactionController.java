package com.personalgarage.service.api.domain.transactions.application;

import com.personalgarage.service.api.domain.transactions.application.interfaces.ITransactionController;
import com.personalgarage.service.api.domain.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RequestMapping("/transactions")
public class TransactionController implements ITransactionController {

    private ITransactionService transactionService;

    public TransactionController() {
    }

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO get(@PathVariable("id") @Validated @NotNull Long id) {
        return transactionService.get(id);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO insert(@RequestBody @Validated({ActionInsert.class}) TransactionDTO transactionDTO) {
        return transactionService.insert(transactionDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO update(@RequestBody @Validated({ActionUpdate.class}) TransactionDTO transactionDTO) {
        return transactionService.update(transactionDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotNull Long id) {
        transactionService.delete(id);
    }
}