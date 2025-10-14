package tn.esprit.tp1.repository;

import tn.esprit.tp1.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // Attention au nom exact de la propriété dans Bloc
    List<Chambre> findByBlocIdBloc(Long idBloc);

}
