package com.kayque.financemanager.repository;

import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kayque.financemanager.entity.TransactionType;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserAndType(User user, TransactionType type);

    Optional<Transaction> findByIdAndUser(Long id, User user);
}