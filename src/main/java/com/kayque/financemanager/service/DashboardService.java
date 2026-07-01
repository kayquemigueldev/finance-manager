package com.kayque.financemanager.service;

import com.kayque.financemanager.dto.DashboardResponse;
import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.TransactionType;
import com.kayque.financemanager.entity.User;
import com.kayque.financemanager.exception.UserNotFoundException;
import com.kayque.financemanager.repository.TransactionRepository;
import com.kayque.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public DashboardResponse getSummary(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        List<Transaction> transactions = transactionRepository.findByUser(user);

        BigDecimal totalIncome = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.INCOME)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalIncome.subtract(totalExpense);

        return new DashboardResponse(
                totalIncome,
                totalExpense,
                balance,
                transactions.size()
        );
    }
}