package projects.pizzeria.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(updatable = false)
    private Long dni;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 10, unique = true)
    private Long phone;
}
