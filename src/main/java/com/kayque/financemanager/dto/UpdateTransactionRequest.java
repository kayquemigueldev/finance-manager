package com.kayque.financemanager.dto;

import com.kayque.financemanager.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateTransactionRequest(

        String description,

        BigDecimal amount,

        TransactionType type,

        LocalDate transactionDate,

        Long categoryId

) {
}