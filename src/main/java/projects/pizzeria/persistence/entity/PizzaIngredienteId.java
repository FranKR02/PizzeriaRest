package projects.pizzeria.persistence.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class PizzaIngredienteId implements Serializable {
    @ManyToOne
    private Pizza idPizza;
    @ManyToOne
    private Ingrediente idIngrediente;
}
