package com.jvsantosdonascimento.springbootjpasql.controller.dto.out;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;

import java.time.Instant;

public record OrderRecordOut(Long id, Instant moment, Users client) {
}
