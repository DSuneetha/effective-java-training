package com.conceptarchitect.miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conceptarchitect.miniproject.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query(value = "SELECT * from review r where r.book_id LIKE %:isbn%", nativeQuery = true)
	List<Review> getReviewByIsbn(String isbn);

	@Query(value = "SELECT * from review r  where r.rating BETWEEN :min AND :max", nativeQuery = true)
	List<Review> getReviewInRange(int min, int max);

	@Query(value = "SELECT * from review r  where r.review LIKE %?1%", nativeQuery = true)
	List<Review> getReviewContainsText(String text);

	@Query(value = "SELECT avg(r.rating) as anyVariableName from review r  where r.book_id LIKE %:isbn%", nativeQuery = true)
	int getAverageRating(String isbn);
}