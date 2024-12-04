package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.yordan.pizzeria.persistence.repository.PizzaRepository;
import com.yordan.pizzeria.service.dto.updatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    //FORMA CON JdbcTemplate
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PizzaService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public List<PizzaEntity> getAll(){
//        return this.jdbcTemplate.query("SELECT * FROM pizza WHERE available=0",new BeanPropertyRowMapper<>(PizzaEntity.class));
//    }
    //Forma con Repository
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }
    //metodo que retorna todas las pizzas
    //modificacion usando PagingAndSortingRepository
    public Page<PizzaEntity> getAll(int page, int elements){
        //return this.pizzaRepository.findAll();
        Pageable pageRequest= PageRequest.of(page,elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }

    //metodo que retorna todas las pizzas menores a un precio
    public List<PizzaEntity> getByPriceLessThan(double price){
        return this.pizzaRepository.findByPriceLessThanEqualOrderByPriceDesc(price);
    }

    //metodo que retorna todas las pizzas que coincida con algun ingrediente
    public List<PizzaEntity> getByIngredient(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainsIgnoreCase(ingredient);
    }

    //metodo que retorna todas las pizzas activas
    //modificacion usando PagingAndSortingRepository
    public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sortDirection){
        Sort sort=Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageRequest= PageRequest.of(page,elements,sort);//sort que incluye ordenamiento y direccion
        return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
    }

    //metodo que retorna una piza buscado por id.
    public Optional<PizzaEntity> getPizza(int idPizza){
        return this.pizzaRepository.findById(idPizza);
    }

    //metodo para guardar una pizza
    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }

    //Verificar si existe o no una pizza
    public boolean exists(int idPizza){
        return this.pizzaRepository.existsById(idPizza);
    }

    //Eliminar una pizza
    public void delete(int idPizza){
        this.pizzaRepository.deleteById(idPizza);
    }
    @Transactional
    //Actualizar el precio de una pizza por ID
    public void udaptePrice(updatePizzaPriceDto dto){
        this.pizzaRepository.UpdatePrice(dto);
    }
}
