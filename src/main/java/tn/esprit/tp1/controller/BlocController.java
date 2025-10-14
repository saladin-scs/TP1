package tn.esprit.tp1.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Bloc;
import tn.esprit.tp1.service.BlocService;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {

    private final BlocService blocService;

    // ✅ Constructeur explicite pour l’injection du service
    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }

    // CREATE
    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        return blocService.updateBloc(id, bloc);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    // READ - ALL
    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    // READ - ONE
    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }
}
