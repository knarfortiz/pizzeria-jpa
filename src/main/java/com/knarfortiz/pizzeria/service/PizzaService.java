package com.knarfortiz.pizzeria.service;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import com.knarfortiz.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll() {
        return (List<PizzaEntity>) pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvailable() {
        System.out.println(pizzaRepository.countByVeganTrue());
        return pizzaRepository.findByAvailableTrueOrderByPrice();
    }

    public PizzaEntity get(Integer id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity) {
        return pizzaRepository.save(pizzaEntity);
    }

    public void delete(Integer id) {
        pizzaRepository.deleteById(id);
    }

    public PizzaEntity getByName(String name) {
        return pizzaRepository.findByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getByDescription(String description) {
        return pizzaRepository.findByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getWithOutDescription(String description) {
        return pizzaRepository.findByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }
}

