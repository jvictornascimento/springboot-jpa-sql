package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.CategoryRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Categories;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ICategoriesMapper {
    CategoryRecordOut fromOut(Categories categories);
    Categories fromEntity(CategoryRecord categoryRecord);
}
