package com.personalgarage.service.api.domain.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.api.domain.transactions.application.TransactionController;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestTransactions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionController transactionsController;

    @Test
    @WithMockUser
    public void givenValidTransactionIdReturnsTransactionDTO() throws Exception {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        when(transactionsController.get(TestTransactions.FUEL_PURCHASE_1.getId())).thenReturn(transaction);

        mockMvc.perform(get("/transactions/{id}", TestTransactions.FUEL_PURCHASE_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(TestTransactions.FUEL_PURCHASE_1.getId().intValue())));

        verify(transactionsController, times(1)).get(TestTransactions.FUEL_PURCHASE_1.getId());
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidTransactionDTOReturnsInsertedTransactionDTO() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        CarDTO car = new CarDTO();
        car.setId(TestTransactions.FUEL_PURCHASE_1.getCarId());

        TransactionDTO insertTransaction = new TransactionDTO();
        insertTransaction.setId(null);
        insertTransaction.setUser(user);
        insertTransaction.setCar(car);
        insertTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        insertTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        insertTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        TransactionDTO resultTransaction = new TransactionDTO();
        resultTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        resultTransaction.setUser(user);
        resultTransaction.setCar(car);
        resultTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        resultTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        resultTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        when(transactionsController.insert(insertTransaction)).thenReturn(resultTransaction);

        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertTransaction)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(TestTransactions.FUEL_PURCHASE_1.getId().intValue())))
                .andExpect(jsonPath("$.user.id", is(TestTransactions.FUEL_PURCHASE_1.getUserId().intValue())));

        verify(transactionsController, times(1)).insert(insertTransaction);
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidTransactionDTOReturnsUpdatedTransactionDTO() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        CarDTO car = new CarDTO();
        car.setId(TestTransactions.FUEL_PURCHASE_1.getCarId());

        TransactionDTO updateTransaction = new TransactionDTO();
        updateTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        updateTransaction.setUser(user);
        updateTransaction.setCar(car);
        updateTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        updateTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        updateTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        TransactionDTO resultTransaction = new TransactionDTO();
        resultTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        resultTransaction.setUser(user);
        resultTransaction.setCar(car);
        resultTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        resultTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        resultTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        when(transactionsController.update(updateTransaction)).thenReturn(resultTransaction);

        mockMvc.perform(put("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writer().writeValueAsBytes(updateTransaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(TestTransactions.FUEL_PURCHASE_1.getId().intValue())))
                .andExpect(jsonPath("$.user.id", is(TestTransactions.FUEL_PURCHASE_1.getUserId().intValue())));

        verify(transactionsController, times(1)).update(updateTransaction);
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidDeleteTransactionIdReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/transactions/{id}", TestTransactions.FUEL_PURCHASE_1.getId()))
                .andExpect(status().isNoContent());

        verify(transactionsController, times(1)).delete(TestTransactions.FUEL_PURCHASE_1.getId());
        verifyNoMoreInteractions(transactionsController);
    }
}