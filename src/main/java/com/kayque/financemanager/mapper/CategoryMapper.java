package com.kayque.financemanager.mapper;

import com.kayque.financemanager.dto.CategoryRequest;
import com.kayque.financemanager.dto.CategoryResponse;
import com.kayque.financemanager.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {

        return Category.builder()
                .name(request.name())
                .type(request.type())
                .build();
    }

    public CategoryResponse toResponse(Category category) {

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getType(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }
}