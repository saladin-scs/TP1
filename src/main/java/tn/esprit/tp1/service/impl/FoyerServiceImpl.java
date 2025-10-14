package tn.esprit.tp1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Foyer;
import tn.esprit.tp1.repository.FoyerRepository;
import tn.esprit.tp1.service.FoyerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements FoyerService {

    private final FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Long id, Foyer foyer) {
        Foyer existingFoyer = foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable avec ID : " + id));

        if (foyer.getNomFoyer() != null)
            existingFoyer.setNomFoyer(foyer.getNomFoyer());

        if (foyer.getCapaciteFoyer() != null)
            existingFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());

        if (foyer.getUniversite() != null)
            existingFoyer.setUniversite(foyer.getUniversite());

        return foyerRepository.save(existingFoyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        if (!foyerRepository.existsById(id)) {
            throw new RuntimeException("Foyer introuvable avec ID : " + id);
        }
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable avec ID : " + id));
    }
}
