package com.jvsantosdonascimento.springbootjpasql.controller;

import com.jvsantosdonascimento.springbootjpasql.business.CategoriesService;
import com.jvsantosdonascimento.springbootjpasql.business.ProductService;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.ProductRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.UserRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.CategoryRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.ProductRecordOut;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductRecordOut>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductRecordOut> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<ProductRecordOut> insertUser(@RequestBody ProductRecord productRecord) {
        var newData = service.insert(productRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.id()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }
}
