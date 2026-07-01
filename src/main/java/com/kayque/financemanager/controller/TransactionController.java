package com.kayque.financemanager.controller;

import com.kayque.financemanager.dto.TransactionRequest;
import com.kayque.financemanager.dto.TransactionResponse;
import com.kayque.financemanager.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.kayque.financemanager.dto.UpdateTransactionRequest;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse create(
            @RequestBody @Valid TransactionRequest request,
            Authentication authentication
    ) {
        return service.create(request, authentication.getName());
    }

    @GetMapping
    public List<TransactionResponse> findAll(Authentication authentication) {
        return service.findAllByUser(authentication.getName());
    }

    @GetMapping("/{id}")
    public TransactionResponse findById(
            @PathVariable Long id,
            Authentication authentication
    ) {
        return service.findById(id, authentication.getName());
    }

    @PutMapping("/{id}")
    public TransactionResponse update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateTransactionRequest request,
            Authentication authentication
    ) {
        return service.update(id, request, authentication.getName());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id,
            Authentication authentication
    ) {
        service.delete(id, authentication.getName());
    }

}