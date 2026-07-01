package com.kayque.financemanager.repository;

import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kayque.financemanager.entity.TransactionType;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserAndType(User user, TransactionType type);
    List<Transaction> findByUserAndTransactionDateBetween(
            User user,
            LocalDate startDate,
            LocalDate endDate
    );

    List<Transaction> findByUserAndTypeAndTransactionDateBetween(
            User user,
            TransactionType type,
            LocalDate startDate,
            LocalDate endDate
    );

    Optional<Transaction> findByIdAndUser(Long id, User user);
}