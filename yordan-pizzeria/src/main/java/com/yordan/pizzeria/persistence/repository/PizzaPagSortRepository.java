package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaPagSortRepository extends PagingAndSortingRepository<PizzaEntity,Integer> {
}
