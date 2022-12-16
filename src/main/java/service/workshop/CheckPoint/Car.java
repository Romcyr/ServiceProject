package hibernate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;
    private String model;
    private String vin;
    private String registeryNumber;

    @OneToMany(mappedBy = "car")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> repairs;

}
