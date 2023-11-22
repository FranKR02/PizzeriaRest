package projects.pizzeria.persistence.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PizzaIngredienteId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private Pizza idPizza;
    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente idIngrediente;
}
