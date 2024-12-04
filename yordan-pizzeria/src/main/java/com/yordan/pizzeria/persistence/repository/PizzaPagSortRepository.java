package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaPagSortRepository extends PagingAndSortingRepository<PizzaEntity,Integer> {
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
}
