package service.workshop.CheckPoint;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;


    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Mechanic mechanic;
    private String description;



    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Car car;

    @CreationTimestamp
    private LocalDateTime timeAddActivities;
}
