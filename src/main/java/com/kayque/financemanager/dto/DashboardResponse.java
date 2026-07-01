package com.kayque.financemanager.dto;

import java.math.BigDecimal;

public record DashboardResponse(
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal balance,
        long transactionCount
) {
}