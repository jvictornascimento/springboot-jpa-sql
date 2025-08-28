package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.in.UserRecord;
import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IUsersMapper {
    UserRecordOut fromOut(Users users);
    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    Users fromEntity(UserRecord userRecord);
    @Named("encodePassword")
    default String encodePassword(String password) {
        if (password == null) return null;
        return new BCryptPasswordEncoder().encode(password);
    }
}
