package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Tamano;

public interface TamanoRepository extends CrudRepository<Tamano, String> {
}
