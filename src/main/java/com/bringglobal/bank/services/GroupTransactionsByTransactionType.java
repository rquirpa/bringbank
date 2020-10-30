package com.bringglobal.bank.services;

import com.bringglobal.bank.models.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupTransactionsByTransactionType {

    private ListTransactions listTransactionsService;

    public GroupTransactionsByTransactionType(ListTransactions listTransactionsService) {
        this.listTransactionsService = listTransactionsService;
    }

    public Map<String, BigDecimal> execute(String accountId) {
        List<Transaction> allTransaction = listTransactionsService.execute(accountId, null);
        return groupByTransactionType(allTransaction);
    }

    private Map<String, BigDecimal> groupByTransactionType(List<Transaction> allTransaction) {
        Map<String, BigDecimal> result = new HashMap<>();
        allTransaction.forEach(transaction -> {
            BigDecimal totalAmount = result.get(transaction.getTransactionType());
            if (totalAmount == null) {
                totalAmount = BigDecimal.ZERO;
            }

            totalAmount = totalAmount.add(transaction.getTransactionAmount());
            result.put(transaction.getTransactionType(), totalAmount);
        });
        return result;
    }

}
