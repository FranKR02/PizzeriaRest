package projects.pizzeria.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/contain/{ingredient}")
    public ResponseEntity<List<Pizza>> containIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(pizzaService.containIngredient(ingredient));
    }
    @GetMapping("/vegan")
    public ResponseEntity<Integer> countVegan(){
        return ResponseEntity.ok(pizzaService.countVegan());
    }
    @GetMapping("/notcontain/{ingredient}")
    public ResponseEntity<List<Pizza>> notContainIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(pizzaService.notContainIngredient(ingredient));
    }
    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<Pizza>> getCheapestPizza(@PathVariable Double price){
        return ResponseEntity.ok(pizzaService.getCheapest(price));
    }
    @GetMapping("/available/{name}")
    public ResponseEntity<Pizza> getAvailableByName(String name){
        return ResponseEntity.ok(pizzaService.getByName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getById(@PathVariable Long id){
        if(pizzaService.exist(id) &  id != null){
            pizzaService.delete(id);
            return ResponseEntity.ok(pizzaService.getById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Pizza> add(@RequestBody Pizza pizza){
        if(!pizzaService.exist(pizza.getIdPizza())){
            return ResponseEntity.ok(pizzaService.save(pizza));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/edit")
    public ResponseEntity<Pizza> edit(@RequestBody Pizza pizza){
        if(pizzaService.exist(pizza.getIdPizza()) &  pizza.getIdPizza() != null){
            return ResponseEntity.ok(pizzaService.save(pizza));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id){
        if(pizzaService.exist(id) &  id != null){
            pizzaService.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
