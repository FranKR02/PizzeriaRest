package projects.pizzeria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.pizzeria.persistence.entity.PizzaIngrediente;
import projects.pizzeria.persistence.entity.PizzaIngredienteId;


public interface PizzaIngredienteRepository extends JpaRepository<PizzaIngrediente, PizzaIngredienteId> {
}
