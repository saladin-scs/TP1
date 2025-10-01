package tn.esprit.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private String nomChambre;
    private int capacite;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    // Many Chambres belong to one Bloc
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    // One-to-Many with Reservation (Bidirectional if needed)
    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();
}
