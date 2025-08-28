package com.jvsantosdonascimento.springbootjpasql.controller;

import com.jvsantosdonascimento.springbootjpasql.business.CategoriesService;
import com.jvsantosdonascimento.springbootjpasql.business.OrdersService;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.CategoryRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.ProductRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.OrderRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoriesController {
    private final CategoriesService service;

    @GetMapping
    public ResponseEntity<List<CategoryRecordOut>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryRecordOut> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryRecordOut> insertUser(@RequestBody CategoryRecord categoryRecord) {
        var newData = service.insert(categoryRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.id()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }
}
