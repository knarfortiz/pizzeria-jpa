package com.knarfortiz.pizzeria.service;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import com.knarfortiz.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public List<PizzaEntity> getAvailable(Boolean available) {
        return pizzaRepository.findByAvailable(available);
    }

    public PizzaEntity get(Integer id) {
        return pizzaRepository.findById(id).orElse(null);
    }
}

