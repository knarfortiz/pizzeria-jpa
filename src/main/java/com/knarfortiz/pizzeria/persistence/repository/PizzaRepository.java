package com.knarfortiz.pizzeria.persistence.repository;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findByAvailableTrueOrderByPrice();
    PizzaEntity findByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
}
