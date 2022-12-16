package hibernate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String qualification;
    private String specification;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> completedServices;
}

