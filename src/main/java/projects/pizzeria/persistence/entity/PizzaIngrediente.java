package projects.pizzeria.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizza_ingrediente")
public class PizzaIngrediente {
    @EmbeddedId
    private PizzaIngredienteId id;
}
