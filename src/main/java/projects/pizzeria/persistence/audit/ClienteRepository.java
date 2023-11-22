package projects.pizzeria.persistence.audit;

import org.springframework.data.repository.CrudRepository;
import projects.pizzeria.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByCelular(String celular);
    Optional<Cliente> findByDireccion(String direccion);
    Optional<List<Cliente>> findAllByNombreIgnoreCase(String name);
    Optional<List<Cliente>> findAllByDireccionContaining(String partialDireccion);
}
