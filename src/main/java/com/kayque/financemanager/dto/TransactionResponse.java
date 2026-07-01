package com.kayque.financemanager.dto;

import com.kayque.financemanager.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionResponse(

        Long id,

        String description,

        BigDecimal amount,

        TransactionType type,

        LocalDate transactionDate,

        String category,

        LocalDateTime createdAt,

        LocalDateTime updatedAt

) {
}