package com.jvsantosdonascimento.springbootjpasql.controller.dto.in;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;

import java.util.Set;

public record ProductRecord(
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<Long> categoryIds

) {
}
