package projects.pizzeria.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import projects.pizzeria.persistence.entity.Pizza;
import projects.pizzeria.persistence.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    public List<Pizza> getAll(){
        return pizzaRepository.findAll();
    }
    public List<Pizza> getNotAvailables(){
        return pizzaRepository.findByAvailableFalse();
    }
    public Pizza getById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
}
