package com.knarfortiz.pizzeria.persistence.repository;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaPagSortRepository extends PagingAndSortingRepository<PizzaEntity, Integer> {
}
