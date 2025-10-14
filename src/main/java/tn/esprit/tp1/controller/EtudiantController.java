package tn.esprit.tp1.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    // ✅ Constructeur explicite pour l’injection
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // CREATE
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(id, etudiant);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    // READ - ALL
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }
}
