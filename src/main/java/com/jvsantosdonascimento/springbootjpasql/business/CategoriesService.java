package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.ICategoriesMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.CategoryRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.CategoriesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository repository;
    private final ICategoriesMapper categoriesMapper;

    public List<CategoryRecordOut> findAll() {
        return repository.findAll().stream().
                map(categoriesMapper::fromOut)
                .toList();
    }
    public CategoryRecordOut findById(Long id) {
        return categoriesMapper.fromOut(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id: " + id + " not found")));
    }

    @Transactional
    public CategoryRecordOut insert(CategoryRecord categoryRecord) {
        return categoriesMapper.fromOut(repository.save(categoriesMapper.fromEntity(categoryRecord)));
    }
}
