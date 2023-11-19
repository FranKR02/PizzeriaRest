package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(length = 100)
    private String address;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
