package com.knarfortiz.pizzeria.service;

import com.knarfortiz.pizzeria.persistence.entity.OrderEntity;
import com.knarfortiz.pizzeria.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findAll() {
        return (List<OrderEntity>) orderRepository.findAll();
    }
}
