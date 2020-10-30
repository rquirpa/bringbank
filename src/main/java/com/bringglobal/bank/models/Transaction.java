package com.bringglobal.bank.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Transaction {

    private String id;
    private String accountId;
    private String counterpartyAccount;
    private String counterpartyName;
    private String counterpartyLogoPath;
    private BigDecimal instructedAmount;
    private String instructedCurrency;
    private BigDecimal transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;

}
