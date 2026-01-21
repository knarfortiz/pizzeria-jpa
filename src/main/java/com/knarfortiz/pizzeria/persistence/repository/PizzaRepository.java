package com.knarfortiz.pizzeria.persistence.repository;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
    public List<PizzaEntity> findByAvailable(Boolean available);
}
