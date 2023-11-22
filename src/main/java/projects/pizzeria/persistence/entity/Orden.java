package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long idOrden;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime date;
    @Column(nullable = false, columnDefinition = "DECIMAL(15,2)")
    private Double total;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "pizzaOrden", fetch = FetchType.EAGER)
    private List<PizzaOrden> pizzasList;
}
