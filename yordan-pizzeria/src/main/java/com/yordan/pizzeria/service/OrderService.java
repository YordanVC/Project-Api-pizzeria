package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import com.yordan.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    //metodo para retornar una lista de ordenes
    public List<OrderEntity> getAll(){
        return this.orderRepository.findAll();
    }
}
