package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {
    @Id
    @Column(name = "id_order", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false)
    private Character method;

    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
}
