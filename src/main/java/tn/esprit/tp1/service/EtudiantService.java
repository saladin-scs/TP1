package tn.esprit.tp1.service;

import tn.esprit.tp1.entity.Etudiant;

import java.util.List;

public interface EtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Long id, Etudiant etudiant);

    void deleteEtudiant(Long id);

    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantById(Long id);
}
