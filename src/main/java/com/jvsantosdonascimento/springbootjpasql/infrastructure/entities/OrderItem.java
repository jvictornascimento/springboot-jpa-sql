package com.jvsantosdonascimento.springbootjpasql.infrastructure.entities;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order_item")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;
    public Double getSubTotal(){
        return price * quantity;
    }
}
