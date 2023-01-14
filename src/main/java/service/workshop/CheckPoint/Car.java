package service.workshop.CheckPoint;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    private String registeryNumber;
    private String reportedDefects;

    @CreationTimestamp
    private LocalDateTime timeAddCarToService;


    @OneToMany(mappedBy = "car")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> repairs;

}
