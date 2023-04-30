package pe.edu.upao.lab_03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upao.lab_03.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b, AVG(r.rating) FROM Book b LEFT JOIN b.reviews r GROUP BY b.id")
            List<Object[]> findBooksWithAvgRating();


}
