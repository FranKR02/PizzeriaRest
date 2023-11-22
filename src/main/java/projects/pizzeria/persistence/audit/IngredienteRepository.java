package projects.pizzeria.persistence.audit;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteRepository extends CrudRepository<Ingrediente, String> {
    Optional<List<Ingrediente>> findAllByIngredienteLikeIgnoreCase(String ingrediente);
}
