package tn.esprit.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"bloc", "reservations"})
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    @Column(nullable = false, length = 100)
    private String nomChambre;

    private int capacite;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    // Plusieurs chambres appartiennent à un même bloc
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    // ✅ Relation OneToMany avec table de jointure chambre_reservation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "chambre_reservation",
            joinColumns = @JoinColumn(name = "chambre_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();
}
