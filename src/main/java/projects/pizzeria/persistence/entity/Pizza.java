package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import projects.pizzeria.persistence.audit.AuditPizzaListener;
import projects.pizzeria.persistence.audit.Auditable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pizza")
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class})
public class Pizza extends Auditable {
    @Id
    @Column(name = "id_pizza", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

}
