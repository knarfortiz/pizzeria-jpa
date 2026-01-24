package com.knarfortiz.pizzeria.web.controller;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import com.knarfortiz.pizzeria.service.PizzaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getPizzas(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(pizzaService.getAll(page, elements));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getPizzasAvailable() {
        return ResponseEntity.ok(pizzaService.getAvailable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> getPizza(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(pizzaService.get(id));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> savePizza(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == null) {
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaService.get(pizzaEntity.getIdPizza()) != null) {
            return ResponseEntity.ok(pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable("id") Integer id) {
        pizzaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getPizzaByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(pizzaService.getByName(name));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<PizzaEntity>> getPizzasByDescription(@PathVariable("description") String description) {
        return ResponseEntity.ok(pizzaService.getByDescription(description));
    }

    @GetMapping("/without-description/{description}")
    public ResponseEntity<List<PizzaEntity>> getPizzasWithOutDescription(@PathVariable("description") String description) {
        return ResponseEntity.ok(pizzaService.getWithOutDescription(description));
    }

    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getTop3ByPriceLessThanOrderByPriceAsc(@PathVariable("price") double price) {
        return ResponseEntity.ok(pizzaService.getTop3ByPriceLessThanOrderByPriceAsc(price));
    }
}
