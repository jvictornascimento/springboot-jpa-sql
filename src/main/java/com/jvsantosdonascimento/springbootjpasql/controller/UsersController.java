package com.jvsantosdonascimento.springbootjpasql.controller;

import com.jvsantosdonascimento.springbootjpasql.business.UsersService;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.UserRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UsersController {
    private final UsersService service;

    @GetMapping
    public ResponseEntity<List<UserRecordOut>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserRecordOut> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<UserRecordOut> insertUser(@RequestBody UserRecord userRecord) {
        var newUser = service.insert(userRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.id()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserRecordOut> updateUser(@PathVariable("id") Long id, @RequestBody UserRecord userRecord) {
        return ResponseEntity.ok(service.update(id,userRecord));
    }
}
