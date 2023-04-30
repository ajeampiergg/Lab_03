package pe.edu.upao.lab_03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.lab_03.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
