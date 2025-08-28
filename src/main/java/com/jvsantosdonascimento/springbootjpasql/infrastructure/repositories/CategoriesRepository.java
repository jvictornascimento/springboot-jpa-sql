package com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
