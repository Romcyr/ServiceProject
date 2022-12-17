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

    private String description;
    private String activities;
    private String cost;

    @CreationTimestamp
    private LocalDateTime timeAdd;


    @ManyToOne
    @ToString.Exclude
    private Mechanic mechanic;

    @ManyToOne
    @ToString.Exclude
    private Car car;
}
