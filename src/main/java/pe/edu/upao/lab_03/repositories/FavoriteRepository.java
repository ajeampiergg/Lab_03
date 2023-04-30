package pe.edu.upao.lab_03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.lab_03.models.FavoriteBook;
import pe.edu.upao.lab_03.models.User;

import java.util.List;


public interface FavoriteRepository extends JpaRepository<FavoriteBook, Long> {

    List<FavoriteBook>findAllByUser(User user);


}
