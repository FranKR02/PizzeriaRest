package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tamanos")
public class Tamano {
    @Id
    @Column(updatable = false)
    private String tamano;
}
