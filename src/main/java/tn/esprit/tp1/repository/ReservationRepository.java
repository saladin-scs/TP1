package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
