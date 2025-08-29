package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.ICategoriesMapper;
import com.jvsantosdonascimento.springbootjpasql.business.mapper.IProductMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.ProductRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.CategoriesRepository;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final CategoriesRepository categoriesRepository;
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
    @Transactional
    public ProductRecordOut insert(ProductRecord productRecord) {
        var newProduct = productMapper.fromEntity(productRecord);

        var categories = categoriesRepository.findAllById(productRecord.categoryIds());
        if (categories.isEmpty()) {
            newProduct.setCategories(new HashSet<>());
        } else {
            newProduct.setCategories(new HashSet<>(categories));
        }
        return productMapper.fromOut(repository.save(newProduct));
    }
}
