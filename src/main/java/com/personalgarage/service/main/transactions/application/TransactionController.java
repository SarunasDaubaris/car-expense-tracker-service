package com.personalgarage.service.main.transactions.application;

import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

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

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO createTransaction(@RequestBody @Validated @NotNull TransactionDTO transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO getTransactionById(@PathVariable("id") @Validated @NotNull Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping(value = "/cars/{carId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactionsByCarId(@PathVariable("carId") @Validated @NotNull Long id) {
        return transactionService.getAllTransactionsByCarId(id);
    }
}