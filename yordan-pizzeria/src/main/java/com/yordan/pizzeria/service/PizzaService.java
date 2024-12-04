package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    //metodo que retorna todas las pizzas
    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    //metodo que retorna todas las pizzas menores a un precio
    public List<PizzaEntity> getByPriceLessThan(double price){
        return this.pizzaRepository.findByPriceLessThan(price);
    }

    //metodo que retorna todas las pizzas que coincida con algun ingrediente
    public List<PizzaEntity> getByIngredient(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainsIgnoreCase(ingredient);
    }

    //metodo que retorna todas las pizzas activas
    public List<PizzaEntity> getAvailable(){
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
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
}
