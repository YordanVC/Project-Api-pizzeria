package com.yordan.pizzeria.web.controller;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import com.yordan.pizzeria.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping()
    public ResponseEntity<List<OrderEntity>> getAll(){
        return new ResponseEntity<>(this.orderService.getAll(), HttpStatus.OK);
    }
}
