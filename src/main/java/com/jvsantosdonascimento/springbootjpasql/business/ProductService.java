package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.ICategoriesMapper;
import com.jvsantosdonascimento.springbootjpasql.business.mapper.IProductMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.ProductRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductListAllRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;
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

    public List<ProductListAllRecordOut> findAll() {
        return repository.findAll().stream().
                map(productMapper::fromOutList)
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
    @Transactional
    public ProductRecordOut update(Long id, ProductRecord productRecord) {
        var data = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product id: " + id + " not found."));

        data.setName(productRecord.name() != null ? productRecord.name() : data.getName());
        data.setDescription(productRecord.description() != null ? productRecord.description() : data.getDescription());
        data.setPrice(productRecord.price() != null ? productRecord.price() : data.getPrice());
        data.setImgUrl(productRecord.imgUrl() != null ? productRecord.imgUrl() : data.getImgUrl());

        if (productRecord.categoryIds() != null && !productRecord.categoryIds().isEmpty()) {
            var listCategory = categoriesRepository.findAllById(productRecord.categoryIds());
            for (Category c : listCategory) {
                data.getCategories().add(c);
            }
        }

        return productMapper.fromOut(repository.save(data));
    }
}
