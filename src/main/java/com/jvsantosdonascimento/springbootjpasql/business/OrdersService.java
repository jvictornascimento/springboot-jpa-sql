package com.jvsantosdonascimento.springbootjpasql.business;

import com.jvsantosdonascimento.springbootjpasql.business.mapper.IOrderMapper;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.OrderRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories.OrdersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository repository;
    private final IOrderMapper orderMapper;

    public List<OrderRecordOut> findAll() {
        return repository.findAll().stream().
                map(orderMapper::fromOut)
                .toList();
    }
    public OrderRecordOut findById(Long id) {
        return orderMapper.fromOut(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id: " + id + " not found")));
    }
}
