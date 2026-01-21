package com.knarfortiz.pizzeria.web.controller;

import com.knarfortiz.pizzeria.persistence.entity.OrderItemEntity;
import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import com.knarfortiz.pizzeria.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping()
    public List<PizzaEntity> getPizzas() {
        return pizzaService.getAll();
    }

    @GetMapping("/available")
    public List<PizzaEntity> getPizzasAvailable() {
        return pizzaService.getAvailable(true);
    }

    @GetMapping("/{id}")
    public PizzaEntity getPizza(@PathVariable("id") Integer id) {
        return pizzaService.get(id);
    }
}
