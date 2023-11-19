package projects.pizzeria.service;

import org.springframework.stereotype.Service;
import projects.pizzeria.persistence.entity.PizzaOrder;
import projects.pizzeria.persistence.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<PizzaOrder> getAll(){
        return orderRepository.findAll();
    }
    public List<PizzaOrder> getTodayOrders(){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return orderRepository.findAllByDateAfter(today);
    }
    public List<PizzaOrder> getOutsideOrders(){
        return orderRepository.findAllByMethodIn(Arrays.asList('D', 'C'));
    }
}
