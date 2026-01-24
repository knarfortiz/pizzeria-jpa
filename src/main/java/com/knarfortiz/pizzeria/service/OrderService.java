package com.knarfortiz.pizzeria.service;

import com.knarfortiz.pizzeria.persistence.entity.OrderEntity;
import com.knarfortiz.pizzeria.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private static final String DELIVERY = "D";
    private static final String CARRY_OUT = "C";
    private static final String ON_SITE = "S";

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findAll() {
        return (List<OrderEntity>) orderRepository.findAll();
    }

    public List<OrderEntity> getTodayOrders() {
        LocalDateTime now = LocalDate.now().atTime(0,0);
        return orderRepository.findByDateAfter(now);
    }

    public List<OrderEntity> getOutsideOrders() {
        List<String> methods = List.of(DELIVERY, CARRY_OUT);
        return orderRepository.findByMethodIn(methods);
    }
}
