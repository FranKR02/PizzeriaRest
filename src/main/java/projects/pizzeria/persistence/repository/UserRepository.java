package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
}
