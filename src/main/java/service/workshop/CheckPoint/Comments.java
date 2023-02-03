package service.workshop.CheckPoint;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String content;
    @ManyToOne
    private Mechanic mechanic;


    @ManyToOne
    private Service service;



}
