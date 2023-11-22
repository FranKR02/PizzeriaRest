package projects.pizzeria.persistence.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.pizzeria.persistence.entity.Cliente;
import projects.pizzeria.persistence.entity.Orden;
import projects.pizzeria.persistence.entity.Pizza;
import projects.pizzeria.persistence.entity.Tamano;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    Optional<List<Orden>> findByDate(LocalDateTime date);
    Optional<List<Orden>> findByDateAfter(LocalDateTime date);
    Optional<List<Orden>> findByDateBefore(LocalDateTime date);
    Optional<List<Orden>> findByTotalGreaterThan(Double total);
    Optional<List<Orden>> findByTotalLessThanEqual(Double total);
    Optional<List<Orden>> findByTotalBetween(Double minTotal, Double maxTotal);
    Optional<List<Orden>> findByCliente(Cliente dni);
    Optional<List<Orden>> findByPizzasListIdPizza(Pizza pizza);
    Optional<List<Orden>> findByPizzasListTamano(Tamano tamano);

}
