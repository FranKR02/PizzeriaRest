package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import projects.pizzeria.persistence.entity.Pizza;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<Pizza, Long> {
    List<Pizza> findByAvailableFalse();
}
