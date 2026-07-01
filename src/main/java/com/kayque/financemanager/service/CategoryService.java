package com.kayque.financemanager.service;

import com.kayque.financemanager.dto.CategoryRequest;
import com.kayque.financemanager.dto.CategoryResponse;
import com.kayque.financemanager.entity.Category;
import com.kayque.financemanager.mapper.CategoryMapper;
import com.kayque.financemanager.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryResponse create(CategoryRequest request) {

        Category category = mapper.toEntity(request);

        category = repository.save(category);

        return mapper.toResponse(category);
    }

    public List<CategoryResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CategoryResponse findById(Long id) {

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return mapper.toResponse(category);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }
}