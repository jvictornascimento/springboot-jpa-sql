package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.ICategoriesMapper;
import com.jvsantosdonascimento.springbootjpasql.business.mapper.IProductMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.CategoriesRepository;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final IProductMapper productMapper;

    public List<ProductRecordOut> findAll() {
        return repository.findAll().stream().
                map(productMapper::fromOut)
                .toList();
    }
    public ProductRecordOut findById(Long id) {
        return productMapper.fromOut(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id: " + id + " not found")));
    }
}
