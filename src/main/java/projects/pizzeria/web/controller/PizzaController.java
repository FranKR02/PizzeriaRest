package projects.pizzeria.web.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.pizzeria.persistence.entity.Pizza;
import projects.pizzeria.service.PizzaService;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    @GetMapping("/")
    public ResponseEntity<Page<Pizza>> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "4") int elements){
        return ResponseEntity.ok(pizzaService.getAll(page, elements));
    }
    @GetMapping("/availables")
    public ResponseEntity<Page<Pizza>> getAvailables(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "4") int elements,
                                                        @RequestParam(defaultValue = "price") String sortBy,
                                                        @RequestParam(defaultValue = "ASC") String sortDirection){
        return ResponseEntity.ok(pizzaService.getAvailables(page, elements, sortBy, sortDirection));
    }
    @GetMapping("/notavailables")
    public ResponseEntity<List<Pizza>> getNotAvailables(){
        return ResponseEntity.ok(pizzaService.getNotAvailables());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getById(@PathVariable Long id){
        return ResponseEntity.ok(pizzaService.getById(id));
    }
}
