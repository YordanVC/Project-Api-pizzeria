package com.yordan.pizzeria.web.controller;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;
    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    //listar todas las pizzas
    @GetMapping()
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return new ResponseEntity<>(pizzaService.getAll(), HttpStatus.OK);
    }

    //busqueda de una pizza por id
    @GetMapping("{id}")
    public ResponseEntity<PizzaEntity> getPizza(@PathVariable("id") int idPizza){
        return new ResponseEntity<>(pizzaService.getPizza(idPizza), HttpStatus.OK);
    }

    //Guardar una pizza
    @PostMapping()
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizza){
        return new ResponseEntity<>(pizzaService.save(pizza), HttpStatus.CREATED);
    }
}
