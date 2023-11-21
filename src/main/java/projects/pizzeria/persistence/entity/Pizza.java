package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @Column(length = 50)
    private String name;
    @Column(length = 100, nullable = false)
    private String description;
    @Column(nullable = false, columnDefinition = "DECIMAL(2,5)")
    private Double price;
    @Column(columnDefinition = "TINYINT DEFAULT 0")
    private Boolean vegan;
    @Column(columnDefinition = "TINYINT DEFAULT 1")
    private Boolean available;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("PERSONAL")
    private Tamano tamano;
    @OneToMany(mappedBy = "id.idPizza", fetch = FetchType.EAGER)
    private List<PizzaIngrediente> ingredienteList;
}
