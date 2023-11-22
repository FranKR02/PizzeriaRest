package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizza_orden")
public class PizzaOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza_orden")
    private Long idPizzaOrden;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(columnDefinition = "DECIMAL(15,2)")
    private Double precioPizzas;
    @ManyToOne
    @Column(name = "id_pizza")
    private Pizza idPizza;
    @ManyToOne
    @JoinColumn(name = "id_tamano", nullable = false)
    private Tamano tamano;
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Orden orden;
}
