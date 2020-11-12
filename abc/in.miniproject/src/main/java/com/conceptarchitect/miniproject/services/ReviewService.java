package com.conceptarchitect.miniproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceptarchitect.miniproject.model.Review;
import com.conceptarchitect.miniproject.repository.ReviewRepository;

@Service
public class ReviewService implements ReviewInterface {
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Review save(Review review,String isbn) {
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public List<Review> findReviewById(String isbn) {
		return reviewRepository.getReviewByIsbn(isbn);
	}

	@Override
	public List<Review> getReviewInRange(int min, int max) {
		return reviewRepository.getReviewInRange(min, max);
	}

	@Override
	public List<Review> getReviewContainsText(String text) {
		return reviewRepository.getReviewContainsText(text);
	}

	@Override
	public int getAverageRating(String isbn) {
		return reviewRepository.getAverageRating(isbn);
	}

}
