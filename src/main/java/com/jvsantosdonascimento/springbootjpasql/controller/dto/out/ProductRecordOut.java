package com.jvsantosdonascimento.springbootjpasql.controller.dto.out;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;

import java.util.Set;

public record ProductRecordOut(Long id, String name, String description, Double price, String imgUrl, Set<CategoryRecordOut> categories) {
}
