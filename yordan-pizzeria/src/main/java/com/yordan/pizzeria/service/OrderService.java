package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import com.yordan.pizzeria.persistence.projection.OrderSummary;
import com.yordan.pizzeria.persistence.repository.OrderRepository;
import com.yordan.pizzeria.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    //metodo para retornar una lista de ordenes de un customer
    public List<OrderEntity> getCustomerOrders(String idCustomer){
        return this.orderRepository.findCustomerOrders(idCustomer);
    }

    public OrderSummary getSummary(int orderId){
        return this.orderRepository.findSummary(orderId);
    }
    //metodo para guardar una orden de la promocion 20% de descuento sobre una pizza aleatoria.
    @Transactional
    public boolean saveRandomOrder(RandomOrderDto dto){
        return this.orderRepository.saveRandomOrder(dto.getIdCustomer(), dto.getMethod());
    }
}
