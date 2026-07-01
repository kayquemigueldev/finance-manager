package com.kayque.financemanager.mapper;

import com.kayque.financemanager.dto.TransactionRequest;
import com.kayque.financemanager.dto.TransactionResponse;
import com.kayque.financemanager.entity.Category;
import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.User;
import org.springframework.stereotype.Component;
import com.kayque.financemanager.dto.UpdateTransactionRequest;

@Component
public class TransactionMapper {

    public Transaction toEntity(
            TransactionRequest request,
            User user,
            Category category
    ) {
        return Transaction.builder()
                .description(request.description())
                .amount(request.amount())
                .type(request.type())
                .transactionDate(request.transactionDate())
                .user(user)
                .category(category)
                .build();
    }

    public TransactionResponse toResponse(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getTransactionDate(),
                transaction.getCategory().getName(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public void updateEntity(
            Transaction transaction,
            UpdateTransactionRequest request,
            Category category
    ) {
        transaction.setDescription(request.description());
        transaction.setAmount(request.amount());
        transaction.setType(request.type());
        transaction.setTransactionDate(request.transactionDate());
        transaction.setCategory(category);
    }

}