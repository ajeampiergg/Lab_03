package pe.edu.upao.lab_03.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upao.lab_03.models.Book;
import pe.edu.upao.lab_03.repositories.BookRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
        private final BookRepository bookRepository;

        @Autowired
        public BookServiceImpl(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        @Override
        public Book createBook(Book book) {
            return null;
        }

        @Override
        public Book getBookById(Long id) {
            return bookRepository.findById(id).orElseThrow(() -> new
                    EntityNotFoundException("Book not found with id " + id));
        }

        @Override
        public Book addBook(Book book) {
            return bookRepository.save(book);
        }

        @Override
        public Book updateBook(Long id, Book bookDetails) {
            Book book = getBookById(id);
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setDescription(bookDetails.getDescription());
            book.setImageUrl(bookDetails.getImageUrl());
            book.setUpdatedAt(LocalDateTime.now());
            return bookRepository.save(book);
        }

        @Override
        public void deleteBook(Long id) {
            bookRepository.delete(getBookById(id));
        }

        @Override
        public List<Book> searchBooks(String keyword) {
            return null;
        }

    }
