package tn.esprit.tp1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Universite;
import tn.esprit.tp1.repository.UniversiteRepository;
import tn.esprit.tp1.service.UniversiteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements UniversiteService {

    private final UniversiteRepository universiteRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Long id, Universite universite) {
        Universite existingUniversite = universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec ID : " + id));

        if (universite.getNomUniversite() != null)
            existingUniversite.setNomUniversite(universite.getNomUniversite());

        if (universite.getAdresse() != null)
            existingUniversite.setAdresse(universite.getAdresse());

        return universiteRepository.save(existingUniversite);
    }

    @Override
    public void deleteUniversite(Long id) {
        if (!universiteRepository.existsById(id)) {
            throw new RuntimeException("Université introuvable avec ID : " + id);
        }
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec ID : " + id));
    }
}
