package com.bringglobal.bank.services;

import com.bringglobal.bank.models.Transaction;
import com.bringglobal.bank.models.external.Transactions;
import com.bringglobal.bank.models.mappers.TransactionMapper;
import com.bringglobal.bank.testdatabuilder.TransactionsTestDataBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTransactionsByTransactionTypeTest {

    @Test
    public void listAllByTransactionType() {
        // arrange
        String account = "savings-kids-john";
        Transactions data = new TransactionsTestDataBuilder().build();

        ListTransactions listTransactionsService = mock(ListTransactions.class);
        when(listTransactionsService.execute(account, null))
                .thenReturn(TransactionMapper.map(data.getTransactions()));

        ListTransactionsByTransactionType service = new ListTransactionsByTransactionType(listTransactionsService);

        // act
        List<Transaction> result = service.execute(account, "XYZ");

        // assert
        assertEquals(2, result.size());
    }

    @Test
    public void noFoundByTransactionType() {
        // arrange
        String account = "savings-kids-john";
        Transactions data = new TransactionsTestDataBuilder().build();

        ListTransactions listTransactionsService = mock(ListTransactions.class);
        when(listTransactionsService.execute(account, null))
                .thenReturn(TransactionMapper.map(data.getTransactions()));

        ListTransactionsByTransactionType service = new ListTransactionsByTransactionType(listTransactionsService);

        // act
        List<Transaction> result = service.execute(account, "DEF");

        // assert
        assertEquals(0, result.size());
    }

}