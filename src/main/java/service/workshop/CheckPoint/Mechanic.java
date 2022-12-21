package service.workshop.CheckPoint;

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
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private String name;



//
//    private String qualification;
//    private String specification;
    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> completedServices;
}

