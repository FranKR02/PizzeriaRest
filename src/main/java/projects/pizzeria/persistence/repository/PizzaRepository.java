package projects.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import projects.pizzeria.persistence.entity.Pizza;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends ListCrudRepository<Pizza, Long> {
    List<Pizza> findByAvailableFalse();
    Optional<Pizza> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String ingredient);
    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(String ingredient);
    List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);
    Integer countByVeganTrue();

}
