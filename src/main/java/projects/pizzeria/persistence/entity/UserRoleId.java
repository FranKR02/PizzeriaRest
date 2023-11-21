package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Getter
@NoArgsConstructor
@Embeddable
public class UserRoleId implements Serializable {
    @Column(length = 20)
    private String role;
    @ManyToOne
    @JoinColumn(name = "username")
    @MapsId
    public User user;
}
