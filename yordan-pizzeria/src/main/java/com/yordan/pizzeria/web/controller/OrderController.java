package com.yordan.pizzeria.web.controller;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import com.yordan.pizzeria.persistence.projection.OrderSummary;
import com.yordan.pizzeria.service.OrderService;
import com.yordan.pizzeria.service.dto.RandomOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Endpoint para retornar una lista de ordenes de un customer
    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String idCustomer){
        return new ResponseEntity<>(this.orderService.getCustomerOrders(idCustomer), HttpStatus.OK);
    }

    //Endpoint para retornar un summary de una Order
    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary> getSummaryOrder(@PathVariable int id){
        return new ResponseEntity<>(this.orderService.getSummary(id), HttpStatus.OK);
    }

    //Endpoint para retornar una lista de ordenes de la dia actual
    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders(){
        return new ResponseEntity<>(this.orderService.getTodayOrders(), HttpStatus.OK);
    }

    //Endpoint para retornar una lista de ordenes de la dia actual
    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders(){
        return new ResponseEntity<>(this.orderService.getOutsideOrders(), HttpStatus.OK);
    }

    //Endpoint para promocion de 20%descuento a una orden donde la pizza es aleatoria
    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto) {
        return new ResponseEntity<>(this.orderService.saveRandomOrder(dto),HttpStatus.OK);
    }
}
