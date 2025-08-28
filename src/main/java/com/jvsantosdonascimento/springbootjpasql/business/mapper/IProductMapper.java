package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Categories;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {
    ProductRecordOut fromOut(Product products);
}
