package tn.esprit.tp1.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Foyer;
import tn.esprit.tp1.service.FoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final FoyerService foyerService;

    // ✅ Constructeur explicite
    public FoyerController(FoyerService foyerService) {
        this.foyerService = foyerService;
    }

    // CREATE
    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        return foyerService.updateFoyer(id, foyer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    // READ - ALL
    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }
}
