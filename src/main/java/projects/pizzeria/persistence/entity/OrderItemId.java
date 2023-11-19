package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @ManyToOne
    @JoinColumn(name = "id_order")
    @MapsId
    private PizzaOrder idOrder;
}
