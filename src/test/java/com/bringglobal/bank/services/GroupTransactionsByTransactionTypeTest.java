package com.bringglobal.bank.services;

import com.bringglobal.bank.models.external.Transactions;
import com.bringglobal.bank.models.mappers.TransactionMapper;
import com.bringglobal.bank.testdatabuilder.TransactionsTestDataBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GroupTransactionsByTransactionTypeTest {

    @Test
    public void groupByTransactionType() {
        // arrange
        String account = "savings-kids-john";
        Transactions data = new TransactionsTestDataBuilder().build();

        ListTransactions listTransactionsService = mock(ListTransactions.class);
        when(listTransactionsService.execute(account, null))
                .thenReturn(TransactionMapper.map(data.getTransactions()));

        GroupTransactionsByTransactionType service = new GroupTransactionsByTransactionType(listTransactionsService);

        // act
        Map<String, BigDecimal> result = service.execute(account);

        // assert
        assertEquals(2, result.size());
        assertEquals(new BigDecimal(2000), result.get("ABC"));
        assertEquals(new BigDecimal(1500), result.get("XYZ"));

    }

}