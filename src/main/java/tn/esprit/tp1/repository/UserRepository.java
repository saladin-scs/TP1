package tn.esprit.tp1.repository;

import tn.esprit.tp1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
