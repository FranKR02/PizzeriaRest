package projects.pizzeria.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.pizzeria.persistence.entity.PizzaOrder;
import projects.pizzeria.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/")
    public ResponseEntity<List<PizzaOrder>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }
    @GetMapping("/today")
    public ResponseEntity<List<PizzaOrder>> getTodayOrders(){
        return ResponseEntity.ok(orderService.getTodayOrders());
    }
    @GetMapping("/outside")
    public ResponseEntity<List<PizzaOrder>> getOutsideOrders(){
        return ResponseEntity.ok(orderService.getOutsideOrders());
    }
    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<PizzaOrder>> getCustomerOrders(@PathVariable Long idCustomer){
        return ResponseEntity.ok(orderService.getCustomerOrders(idCustomer));
    }
}
