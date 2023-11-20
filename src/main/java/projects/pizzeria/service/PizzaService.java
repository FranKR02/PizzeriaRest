package projects.pizzeria.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.pizzeria.persistence.entity.Pizza;
import projects.pizzeria.persistence.repository.PizzaPageSortRepository;
import projects.pizzeria.persistence.repository.PizzaRepository;
import projects.pizzeria.service.dto.UpdatePizzaPrieDTO;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPageSortRepository pageSortRepository;

    public PizzaService(PizzaRepository pizzaRepository, PizzaPageSortRepository pageSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pageSortRepository = pageSortRepository;
    }

    public Page<Pizza> getAll(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return pageSortRepository.findAll(pageRequest);
    }
    public Page<Pizza> getAvailables(int page, int elements, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return pageSortRepository.findByAvailableTrue(pageRequest);
    }
    public Pizza getById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }
    public Boolean exist(Long id){
        return pizzaRepository.existsById(id);
    }
    public void delete(Long id){
        pizzaRepository.deleteById(id);
    }
    public Pizza getByName(String name){
        return pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElse(null);
    }
    public List<Pizza> containIngredient(String ingredient){
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }
    public List<Pizza> notContainIngredient(String ingredient){
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(ingredient);
    }
    public List<Pizza> getCheapest(Double price){
        return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }
    public Integer countVegan(){
        return pizzaRepository.countByVeganTrue();
    }
    @Transactional
    public void updatePrice(UpdatePizzaPrieDTO dto){
        pizzaRepository.updatePrice(dto);
    }
}
