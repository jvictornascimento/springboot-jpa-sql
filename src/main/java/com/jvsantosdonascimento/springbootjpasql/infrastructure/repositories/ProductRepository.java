package com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
