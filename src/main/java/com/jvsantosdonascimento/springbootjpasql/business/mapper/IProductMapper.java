package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.ProductRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductListAllRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {
    ProductRecordOut fromOut(Product products);
    ProductListAllRecordOut fromOutList(Product products);
    @Mapping(target = "categories", ignore = true)
    Product fromEntity(ProductRecord productRecord);
    default Set<CategoryRecordOut> mapCategories(Set<Category> categories) {
        return categories.stream()
                .map(c -> new CategoryRecordOut(c.getId(), c.getName()))
                .collect(Collectors.toSet());
    }
}
