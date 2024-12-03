package com.yordan.pizzeria.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class OrderItemPK implements Serializable {
    @Column(name = "id_item",nullable = false)
    private Integer idItem;
    @Column(name = "id_order",nullable = false)
    private Integer idOrder;
}
