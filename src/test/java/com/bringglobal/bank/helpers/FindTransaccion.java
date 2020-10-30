package com.bringglobal.bank.helpers;

import com.bringglobal.bank.models.Transaction;

import java.util.List;
import java.util.Optional;

public class FindTransaccion {

    private FindTransaccion() {}

    public static Optional<Transaction> byId(List<Transaction> transactions, String id) {
        return transactions.stream().filter(transaction -> transaction.getId().equals(id)).findFirst();
    }
}
