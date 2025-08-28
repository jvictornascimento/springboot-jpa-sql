package com.jvsantosdonascimento.springbootjpasql.infrastructure.repositories;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
