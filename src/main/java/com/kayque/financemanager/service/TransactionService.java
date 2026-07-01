package com.kayque.financemanager.service;

import com.kayque.financemanager.dto.TransactionRequest;
import com.kayque.financemanager.dto.TransactionResponse;
import com.kayque.financemanager.entity.Category;
import com.kayque.financemanager.entity.Transaction;
import com.kayque.financemanager.entity.User;
import com.kayque.financemanager.mapper.TransactionMapper;
import com.kayque.financemanager.repository.CategoryRepository;
import com.kayque.financemanager.repository.TransactionRepository;
import com.kayque.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kayque.financemanager.dto.UpdateTransactionRequest;
import com.kayque.financemanager.exception.CategoryNotFoundException;
import com.kayque.financemanager.exception.TransactionNotFoundException;
import com.kayque.financemanager.exception.UserNotFoundException;
import com.kayque.financemanager.entity.TransactionType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;

    public TransactionResponse create(TransactionRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Transaction transaction = transactionMapper.toEntity(request, user, category);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return transactionMapper.toResponse(savedTransaction);
    }

    public List<TransactionResponse> findAllByUser(String email, TransactionType type) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        List<Transaction> transactions;

        if (type == null) {
            transactions = transactionRepository.findByUser(user);
        } else {
            transactions = transactionRepository.findByUserAndType(user, type);
        }

        return transactions.stream()
                .map(transactionMapper::toResponse)
                .toList();
    }


    public TransactionResponse findById(Long id, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        return transactionMapper.toResponse(transaction);
    }

    public TransactionResponse update(
            Long id,
            UpdateTransactionRequest request,
            String email
    ) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        transactionMapper.updateEntity(transaction, request, category);

        Transaction updatedTransaction = transactionRepository.save(transaction);

        return transactionMapper.toResponse(updatedTransaction);
    }

    public void delete(Long id, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        transactionRepository.delete(transaction);
    }

}