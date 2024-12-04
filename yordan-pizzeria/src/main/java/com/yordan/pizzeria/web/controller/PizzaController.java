package com.yordan.pizzeria.web.controller;

import com.yordan.pizzeria.persistence.entity.PizzaEntity;
import com.yordan.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "6") int elements){
        return new ResponseEntity<>(pizzaService.getAll(page, elements), HttpStatus.OK);
    }

    //listar todas las pizzas menores a un precio
    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getByPriceLessThan(@PathVariable double price){
        return new ResponseEntity<>(pizzaService.getByPriceLessThan(price), HttpStatus.OK);
    }

    //listar todas las pizzas que coincidan con el ingrediente buscado
    @GetMapping("/ingredient/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getByIngredient(@PathVariable String ingredient){
        return new ResponseEntity<>(pizzaService.getByIngredient(ingredient), HttpStatus.OK);
    }

    //listar todas las pizzas activas
    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable(){
        return new ResponseEntity<>(pizzaService.getAvailable(), HttpStatus.OK);
    }

    //busqueda de una pizza por id
    @GetMapping("{id}")
    public ResponseEntity<PizzaEntity> getPizza(@PathVariable("id") int idPizza){
        return pizzaService.getPizza(idPizza)
                .map(pizzaEntity -> new ResponseEntity<>(pizzaEntity,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Guardar una pizza
    @PostMapping()
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza()==null || !this.pizzaService.exists(pizza.getIdPizza())){//consultar si existe antes de insertar
            return new ResponseEntity<>(pizzaService.save(pizza), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();//si ya existe parar la peticion.
    }

    //Actualizar una pizza
    @PutMapping()
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())){//consultar si existe antes de actualizar
            return ResponseEntity.ok(pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();//si ya existe parar la peticion.
    }

    //Eliminar una pizza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int idPizza){
        if(this.pizzaService.exists(idPizza)){
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
