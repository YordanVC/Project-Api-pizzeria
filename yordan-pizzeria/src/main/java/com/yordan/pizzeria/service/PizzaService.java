package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private PizzaRepository pizzaRepository;
    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }
}
