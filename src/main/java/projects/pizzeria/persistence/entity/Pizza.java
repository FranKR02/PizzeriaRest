package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @Column(length = 50, unique = true)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String descripcion;
    @Column(nullable = false, columnDefinition = "DECIMAL(15,2)")
    private Double precio;
    @Column(columnDefinition = "TINYINT DEFAULT 0")
    private Boolean vegana;
    @Column(columnDefinition = "TINYINT DEFAULT 1")
    private Boolean disponible;
    @OneToMany(mappedBy = "id.idPizza", fetch = FetchType.EAGER)
    private List<PizzaIngrediente> ingredienteList;
}
