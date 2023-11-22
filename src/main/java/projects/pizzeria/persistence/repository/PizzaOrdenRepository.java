package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Orden;
import projects.pizzeria.persistence.entity.Pizza;
import projects.pizzeria.persistence.entity.PizzaOrden;
import projects.pizzeria.persistence.entity.Tamano;

import java.util.List;
import java.util.Optional;

public interface PizzaOrdenRepository extends CrudRepository<PizzaOrden, Long> {
    Optional<List<PizzaOrden>> findByOrden(Orden orden);
    Optional<List<PizzaOrden>> findByTamano(Tamano tamano);
    Optional<List<PizzaOrden>> findByIdPizza(Pizza pizza);
    Optional<List<PizzaOrden>> findByCantidadLessThanEqual(Integer cantidad);
    Optional<List<PizzaOrden>> findByPrecioPizzasLessThanEqual(Double precio);

}
