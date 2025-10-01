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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;

    // Many Blocs belong to one Foyer
    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    // Bidirectional One-to-Many with Chambre
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Chambre> chambres = new ArrayList<>();
}
