package com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
