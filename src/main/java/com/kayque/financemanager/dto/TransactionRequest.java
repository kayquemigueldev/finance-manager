package com.kayque.financemanager.dto;

import com.kayque.financemanager.entity.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequest(

        @NotBlank
        String description,

        @NotNull
        BigDecimal amount,

        @NotNull
        TransactionType type,

        @NotNull
        LocalDate transactionDate,

        @NotNull
        Long categoryId

) {
}