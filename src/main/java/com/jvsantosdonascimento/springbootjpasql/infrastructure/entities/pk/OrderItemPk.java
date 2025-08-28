package com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.pk;

import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Orders;
import com.jvsantosdonascimento.springbootjpasql.infrastructure.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderItemPk implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
