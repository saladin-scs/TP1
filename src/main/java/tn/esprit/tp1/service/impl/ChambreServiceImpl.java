package tn.esprit.tp1.service.impl;

import tn.esprit.tp1.entity.Chambre;
import tn.esprit.tp1.repository.ChambreRepository;
import tn.esprit.tp1.service.ChambreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepository chambreRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        Optional<Chambre> existing = chambreRepository.findById(chambre.getIdChambre());
        if (existing.isPresent()) {
            Chambre updated = existing.get();
            updated.setNomChambre(chambre.getNomChambre());
            updated.setCapacite(chambre.getCapacite());
            updated.setTypeChambre(chambre.getTypeChambre());
            updated.setBloc(chambre.getBloc());
            updated.setReservations(chambre.getReservations());
            return chambreRepository.save(updated);
        }
        return null; // ou lancer exception
    }

    @Override
    public List<Chambre> allChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> findByBlocId(Long idBloc) {
        return chambreRepository.findByBlocIdBloc(idBloc);
    }
}
