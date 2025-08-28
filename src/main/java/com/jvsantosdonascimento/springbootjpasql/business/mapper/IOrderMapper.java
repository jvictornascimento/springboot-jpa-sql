package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.OrderRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Orders;
import org.mapstruct.Mapper;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface IOrderMapper {
    OrderRecordOut fromOut(Orders order);
}
