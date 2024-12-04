package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.service.dto.updatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    //Query Methods
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    List<PizzaEntity> findByPriceLessThanEqualOrderByPriceDesc(double price);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainsIgnoreCase(String ingredient);
       /* @Query(value =
                "UPDATE pizza " +
                "SET price= :newPrice" +
                "WHERE id_pizza= :idPizza",nativeQuery = true)
        void UpdatePrice(@Param("idPizza") int idPizza,@Param("newPrice") double newPrice);*/

    //usando SpEL
    @Query(value =
            "UPDATE pizza " +
            "SET price= :#{#newPizzaPrice.newPrice} " +
            "WHERE id_pizza= :#{#newPizzaPrice.idPizza} ",nativeQuery = true)
    @Modifying
    void UpdatePrice(@Param("newPizzaPrice") updatePizzaPriceDto newPizzaPrice);

}
