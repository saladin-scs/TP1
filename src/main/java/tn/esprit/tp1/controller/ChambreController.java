package tn.esprit.tp1.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Chambre;
import tn.esprit.tp1.service.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    private final ChambreService chambreService;

    // ✅ Constructeur explicite pour injecter le service
    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.allChambres();
    }

    @GetMapping("/bloc/{idBloc}")
    public List<Chambre> getChambresByBloc(@PathVariable Long idBloc) {
        return chambreService.findByBlocId(idBloc);
    }
}
