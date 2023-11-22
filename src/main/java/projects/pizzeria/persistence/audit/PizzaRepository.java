package projects.pizzeria.persistence.audit;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndNombreIgnoreCaseContaining(String nombre);
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndDescripcionIgnoreCaseContaining(String descripcion);
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndPrecio(Double precio);
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndPrecioLessThan(Double precio);
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndPrecioBetween(Double minPrecio, Double maxPrecio);
    Optional<List<Pizza>> findAllByDisponibleIsTrueAndVeganaIsTrue();
    Optional<List<Pizza>> findAllByDisponibleIsTrue();
    Optional<List<Pizza>> findAllByDisponibleIsFalse();
    Optional<List<Pizza>> findAllByIngredienteListContains(String ingredient);

}
