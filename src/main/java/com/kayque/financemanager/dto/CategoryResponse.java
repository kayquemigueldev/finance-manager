package com.kayque.financemanager.dto;

import com.kayque.financemanager.entity.CategoryType;

import java.time.LocalDateTime;

public record CategoryResponse(
        Long id,
        String name,
        CategoryType type,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}