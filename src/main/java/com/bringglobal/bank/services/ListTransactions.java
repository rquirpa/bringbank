package com.bringglobal.bank.services;

import com.bringglobal.bank.models.Transaction;
import com.bringglobal.bank.models.external.Transactions;
import com.bringglobal.bank.models.mappers.TransactionMapper;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class ListTransactions {

    private static final String BASE_URL = "https://apisandbox.openbankproject.com/obp/v1.2.1";
    private static final String TRANSACTION_URL = BASE_URL + "/banks/rbs/accounts/%s/public/transactions";

    private final RestTemplate restTemplate;

    public ListTransactions(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Transaction> execute(String accountId,
                                     String sortBy) {
        ResponseEntity<Transactions> response = restTemplate.exchange(
                buildUrl(accountId),
                HttpMethod.GET,
                buildHttpEntity(),
                Transactions.class
        );
        Transactions data = response.getBody();

        List<com.bringglobal.bank.models.external.Transaction> transactions = data.getTransactions();
        List<Transaction> result = TransactionMapper.map(transactions);

        List<Transaction> sortedResult = sort(new ArrayList<>(result), sortBy);
        return sortedResult;
    }

    private List<Transaction> sort(List<Transaction> transactions, String sortBy) {
        if (transactions == null || transactions.size() <= 1) {
            return transactions;
        }

        boolean reverse = StringUtils.hasLength(sortBy) && sortBy.startsWith("-");
        if (reverse) {
            sortBy = sortBy.substring(1);
        }

        try {
            Field privateField = Transaction.class.getDeclaredField(sortBy);
            privateField.setAccessible(true);

            if (privateField.getType().equals(BigDecimal.class)) {
                sortDouble(transactions, privateField);
            } else {
                sortString(transactions, privateField);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (reverse) {
            Collections.reverse(transactions);
        }

        return transactions;
    }

    private void sortDouble(List<Transaction> transactions, Field privateField) {
        Collections.sort(transactions, Comparator.comparingDouble(transaction -> {
            Object value = null;
            try {
                value = privateField.get(transaction);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new BigDecimal(value.toString()).doubleValue();
        }));
    }

    private void sortString(List<Transaction> transactions, Field privateField) {
        Collections.sort(transactions, Comparator.comparing(transaction -> {
            Object value = null;
            try {
                value = privateField.get(transaction);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return value.toString();
        }));
    }

    public String buildUrl(String accountId) {
        return String.format(TRANSACTION_URL, accountId);
    }

    public HttpEntity<String> buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }

}
