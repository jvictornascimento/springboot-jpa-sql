package com.jvsantosdonascimento.springbootjpasql.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private String phone;
    @NonNull
    private String password;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();
}
