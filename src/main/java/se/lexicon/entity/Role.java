package se.lexicon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "user")

@Entity
@Table(name = "role")

public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false)
    private RoleType type;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Constructor
    private Role(RoleType type) {
        this.type = type;

    }
    //Methods
    public static Role valueOf(RoleType roleType) {
       return new Role(roleType);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Role)) return false;

        Role role = (Role) obj;
        return id != null && id.equals(role.id);
    }
}
