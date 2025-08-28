package com.jvsantosdonascimento.springbootjpasql.business.mapper;

import com.jvsantosdonascimento.springbootjpasql.controller.dto.out.OrderRecordOut;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Orders;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.enums.OrderStatus;
import org.mapstruct.Mapper;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface IOrderMapper {
    OrderRecordOut fromOut(Orders order);
    default Integer map(OrderStatus status) {
        return (status == null) ? null : status.getCode();
    }

    default OrderStatus map(Integer code) {
        return (code == null) ? null : OrderStatus.valueOf(code);
    }
}
