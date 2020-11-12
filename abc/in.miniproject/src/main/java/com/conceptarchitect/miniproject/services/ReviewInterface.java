package com.conceptarchitect.miniproject.services;

import java.util.List;

import com.conceptarchitect.miniproject.model.Review;

public interface ReviewInterface {

	Review save(Review review,String isbn);

	List<Review> getAllReviews();

	List<Review> findReviewById(String isbn);

	List<Review> getReviewInRange(int min, int max);

	List<Review> getReviewContainsText(String text);

	int getAverageRating(String isbn);

}
