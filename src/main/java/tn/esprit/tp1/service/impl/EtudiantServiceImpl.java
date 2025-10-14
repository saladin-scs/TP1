package tn.esprit.tp1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.repository.EtudiantRepository;
import tn.esprit.tp1.service.EtudiantService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec ID : " + id));

        if (etudiant.getNomEt() != null) existingEtudiant.setNomEt(etudiant.getNomEt());
        if (etudiant.getPrenomEt() != null) existingEtudiant.setPrenomEt(etudiant.getPrenomEt());
        if (etudiant.getCin() != null) existingEtudiant.setCin(etudiant.getCin());
        if (etudiant.getEcole() != null) existingEtudiant.setEcole(etudiant.getEcole());
        if (etudiant.getDateNaissance() != null) existingEtudiant.setDateNaissance(etudiant.getDateNaissance());

        return etudiantRepository.save(existingEtudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        if (!etudiantRepository.existsById(id)) {
            throw new RuntimeException("Étudiant introuvable avec ID : " + id);
        }
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec ID : " + id));
    }
}
