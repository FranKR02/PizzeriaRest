package projects.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class UserRole {
    @EmbeddedId
    private UserRoleId id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "granted_date", nullable = false)
    private LocalDateTime grantedDate;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
}
