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

    @ToString.Exclude
    private String IdMechanic;
    private String description;

    @CreationTimestamp
    private LocalDateTime timeAddActivities;

    @ManyToOne
    @ToString.Exclude
    private Car car;
}
