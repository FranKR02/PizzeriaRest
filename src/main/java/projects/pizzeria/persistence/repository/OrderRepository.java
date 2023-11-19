package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import projects.pizzeria.persistence.entity.PizzaOrder;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<PizzaOrder, Long> {
    List<PizzaOrder> findAllByDateAfter(LocalDateTime fecha);
    List<PizzaOrder> findAllByMethodIn(List<Character> methods);
}
