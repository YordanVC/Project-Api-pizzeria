package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import com.yordan.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private static final String DELIVERY= "D";
    private static final String CARRYOUT= "C";
    private static final String ON_SITE= "S";

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    //metodo para retornar una lista de ordenes
    public List<OrderEntity> getAll(){
        return this.orderRepository.findAll();
    }

    //metodo para retornar una lista de ordenes por fecha
    public List<OrderEntity> getTodayOrders(){
        LocalDateTime today=LocalDate.now().atTime(0,0);
        return this.orderRepository.findAllByDateAfter(today);
    }

    //metodo para retornar una lista de ordenes por su metodo
    public List<OrderEntity> getOutsideOrders(){
        List<String> methods= Arrays.asList(DELIVERY,CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }
}
