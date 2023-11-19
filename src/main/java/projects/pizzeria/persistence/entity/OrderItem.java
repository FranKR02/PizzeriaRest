package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @OneToOne
    @JoinColumn(name = "id_pizza", nullable = false, referencedColumnName = "id_pizza", updatable = false)
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id_order", updatable = false)
    private PizzaOrder pizzaOrder;
}
