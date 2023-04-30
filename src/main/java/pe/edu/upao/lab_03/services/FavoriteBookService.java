package pe.edu.upao.lab_03.services;

import pe.edu.upao.lab_03.models.Book;
import pe.edu.upao.lab_03.models.FavoriteBook;
import pe.edu.upao.lab_03.models.User;
import java.util.List;

public interface FavoriteBookService {
    FavoriteBook saveFavorite(FavoriteBook favoriteBook);

    void deleteFavoriteById(Long id);

    List<FavoriteBook> getAllFavoritesByUser(User user);

    FavoriteBook addFavoriteBook(Long bookId, Long userId);
    List<Book> getFavoriteBooksByUserId(Long userId);
    void removeFavoriteBook(Long bookId, Long userId);
}
