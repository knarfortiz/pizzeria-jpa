package com.knarfortiz.pizzeria.persistence.repository;

import com.knarfortiz.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
