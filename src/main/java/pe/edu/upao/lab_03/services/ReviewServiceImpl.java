package pe.edu.upao.lab_03.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upao.lab_03.models.Book;
import pe.edu.upao.lab_03.models.Review;
import pe.edu.upao.lab_03.models.User;
import pe.edu.upao.lab_03.repositories.BookRepository;
import pe.edu.upao.lab_03.repositories.ReviewRepository;
import pe.edu.upao.lab_03.repositories.UserRepository;


import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             BookRepository bookRepository,
                             UserRepository userRepository){
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @Override
    public Review addReview(Long bookId, Long userId, Review review){
        Book book = bookRepository.findById(bookId).orElseThrow(()->new
                EntityNotFoundException("Book not found with id "+bookId));
        User user = userRepository.findById(userId).orElseThrow(()->new
                EntityNotFoundException("User not found with id "+userId));
        review.setBook(book);
        review.setUser(user);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review reviewDetails){
        Review review = getReviewsById(id);
        review.setTitle(reviewDetails.getTitle());
        review.setComment(reviewDetails.getComment());
        review.setRating(reviewDetails.getRating());
        review.setUpdatedAt(LocalDateTime.now());
        return review;
    }

    private Review getReviewsById(Long id) {
        return   reviewRepository.findById(id).orElseThrow(()->new
                EntityNotFoundException("Review not found with id "+id));
    }

    @Override
    public Review createReview(Review review, Long bookId, Long userId) {
        return null;
    }

    @Override
    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public Review getReviewByBookIdAndUserId(Long bookId, Long userId) {
        return null;
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(getReviewById(id));
    }

    private Review getReviewById(Long id) {
        return null;
    }

    @Override
    public Review addReview(Long bookId, Long userId, String title, String comment, Integer rating) {
        return null;
    }

    @Override
    public List<Review> getReviewsByUserId() {
        return null;
    }
}