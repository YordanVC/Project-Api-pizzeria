package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    //Query Methods
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    List<PizzaEntity> findByPriceLessThan(double price);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainsIgnoreCase(String ingredient);
}
