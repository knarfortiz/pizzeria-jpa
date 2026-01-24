package com.knarfortiz.pizzeria.service;

import com.knarfortiz.pizzeria.persistence.entity.PizzaEntity;
import com.knarfortiz.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.knarfortiz.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return pizzaPagSortRepository.findAll(pageRequest);
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
        return pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getByDescription(String description) {
        return pizzaRepository.findByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getWithOutDescription(String description) {
        return pizzaRepository.findByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getTop3ByPriceLessThanOrderByPriceAsc(double price) {
        return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanOrderByPriceAsc(price);
    }
}

