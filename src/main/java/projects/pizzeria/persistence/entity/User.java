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
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disable;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> roleList;

}
