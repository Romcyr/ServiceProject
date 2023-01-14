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

    private Long IdComment;
    @ToString.Exclude
    private String IdMechanic;
    private String Comments;



}
