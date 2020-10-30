package com.bringglobal.bank.controllers;

import com.bringglobal.bank.models.Transaction;
import com.bringglobal.bank.services.GroupTransactionsByTransactionType;
import com.bringglobal.bank.services.ListTransactions;
import com.bringglobal.bank.services.ListTransactionsByTransactionType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/current-accounts")
public class TransactionController {


    private ListTransactions listTransactionsService;
    private ListTransactionsByTransactionType listByTransactionTypeService;
    private GroupTransactionsByTransactionType groupByTransactionTypeService;

    public TransactionController(ListTransactions listTransactionsService,
                                 ListTransactionsByTransactionType listByTransactionTypeService,
                                 GroupTransactionsByTransactionType groupByTransactionTypeService) {
        this.listTransactionsService = listTransactionsService;
        this.listByTransactionTypeService = listByTransactionTypeService;
        this.groupByTransactionTypeService = groupByTransactionTypeService;
    }

    @GetMapping("/{accountId}/transactions")
    public List<Transaction> list(
            @PathVariable String accountId,
            @RequestParam("sort") String sortBy
    ) {
        return listTransactionsService.execute(accountId, sortBy);
    }

    @GetMapping("/{accountId}/transactions-type/{transactionType}")
    public List<Transaction> listByTransactionType(@PathVariable String accountId, @PathVariable String transactionType) {
        return listByTransactionTypeService.execute(accountId, transactionType);
    }

    @GetMapping("/{accountId}/total-amounts")
    public Map<String, BigDecimal> amountGroupByTransactionType(@PathVariable String accountId) {
        return groupByTransactionTypeService.execute(accountId);
    }

}
