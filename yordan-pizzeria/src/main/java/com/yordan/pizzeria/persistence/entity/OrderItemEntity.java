package com.yordan.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPK id;

    @Column(name ="id_pizza",nullable = false)
    private Integer idPizza;

    @Column(nullable = false,columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
    private Double price;

    //Relaciones de DB
    @ManyToOne
    @JoinColumn(name = "id_order",referencedColumnName = "id_order",insertable = false,updatable = false)
    @JsonIgnore
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_pizza",referencedColumnName = "id_pizza",insertable = false,updatable = false)
    private PizzaEntity pizza;

}
