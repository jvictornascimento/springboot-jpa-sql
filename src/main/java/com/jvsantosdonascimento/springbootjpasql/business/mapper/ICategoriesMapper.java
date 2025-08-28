package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.CategoryRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ICategoriesMapper {
    CategoryRecordOut fromOut(Category category);
    Category fromEntity(CategoryRecord categoryRecord);
}
