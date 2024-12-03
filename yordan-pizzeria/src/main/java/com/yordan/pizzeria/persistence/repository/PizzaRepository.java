package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

}
