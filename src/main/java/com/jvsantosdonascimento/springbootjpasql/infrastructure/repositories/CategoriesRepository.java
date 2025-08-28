package com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}
