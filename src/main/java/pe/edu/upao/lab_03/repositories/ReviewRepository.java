package pe.edu.upao.lab_03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.lab_03.models.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBookId(Long bookId);
    List<Review> finByUserId(Long userId);
}
