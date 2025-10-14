package tn.esprit.tp1.service;

import tn.esprit.tp1.entity.Foyer;

import java.util.List;

public interface FoyerService {

    Foyer addFoyer(Foyer foyer);

    Foyer updateFoyer(Long id, Foyer foyer);

    void deleteFoyer(Long id);

    List<Foyer> getAllFoyers();

    Foyer getFoyerById(Long id);
}
