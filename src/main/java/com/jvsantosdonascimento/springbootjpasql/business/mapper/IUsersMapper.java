package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.UserRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Users;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IUsersMapper {
    UserRecordOut fromOut(Users users);
}
