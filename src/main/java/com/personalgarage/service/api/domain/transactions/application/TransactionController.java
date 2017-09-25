package com.personalgarage.service.api.domain.transactions.application;

import com.personalgarage.service.api.domain.transactions.application.services.TransactionService;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController() {
    }

    @Autowired
    public TransactionController(TransactionService transactionService) {
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