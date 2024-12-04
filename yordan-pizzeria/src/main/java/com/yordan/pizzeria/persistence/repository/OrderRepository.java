package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity,Integer> {

}
