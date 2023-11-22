package projects.pizzeria.persistence.audit;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Orden;
import projects.pizzeria.persistence.entity.PizzaOrden;

import java.util.List;
import java.util.Optional;

public interface PizzaOrdenRepository extends CrudRepository<PizzaOrden, Long> {
    Optional<List<PizzaOrden>> findByOrden(Orden orden);
    Optional<List<PizzaOrden>> findByTamano(String tamano);
    Optional<List<PizzaOrden>> findByIdPizza(String pizza);
    Optional<List<PizzaOrden>> findByCantidadLessThanEqual(Integer cantidad);
    Optional<List<PizzaOrden>> findByPrecioPizzasLessThanEqual(Double precio);

}
