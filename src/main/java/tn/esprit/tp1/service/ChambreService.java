package tn.esprit.tp1.service;

import tn.esprit.tp1.entity.Chambre;

import java.util.List;

public interface ChambreService {

    Chambre addChambre(Chambre chambre);

    void deleteChambre(Long idChambre);

    Chambre updateChambre(Chambre chambre);

    List<Chambre> allChambres();

    List<Chambre> findByBlocId(Long idBloc);
}
