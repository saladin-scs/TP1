package tn.esprit.tp1.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Universite;
import tn.esprit.tp1.service.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universites")
public class UniversiteController {

    private final UniversiteService universiteService;

    public UniversiteController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    // CREATE
    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return universiteService.updateUniversite(id, universite);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    // READ - ALL
    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }
}
