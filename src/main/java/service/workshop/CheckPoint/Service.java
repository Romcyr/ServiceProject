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
    private Long id;

    @ToString.Exclude
    private String nameMechanic;
    private String description;

    @CreationTimestamp
    private LocalDateTime timeAdd;

    @ManyToOne
    @ToString.Exclude
    private Car car;
}
