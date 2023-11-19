package projects.pizzeria.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import projects.pizzeria.persistence.entity.Pizza;

@Repository
public interface PizzaPageSortRepository extends ListPagingAndSortingRepository<Pizza, Long> {
    Page<Pizza> findByAvailableTrue(Pageable pageable);
}
