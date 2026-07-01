package com.kayque.financemanager.repository;

import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);
}