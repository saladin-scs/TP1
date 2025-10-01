package tn.esprit.tp1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    // mappedBy indicates that Foyer owns the relationship
    @OneToOne(mappedBy = "universite")
    private Foyer foyer;
}
