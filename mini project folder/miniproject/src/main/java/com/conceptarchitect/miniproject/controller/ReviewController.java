package com.conceptarchitect.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conceptarchitect.miniproject.model.Review;
import com.conceptarchitect.miniproject.services.ReviewService;

@RestController
@RequestMapping("/api/review")
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// save review for a book
	@PostMapping("/")
	public void addReview(@RequestBody Review review) {
		reviewService.save(review);
	}

	// get all reviews
	@GetMapping("/")
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	// get reviews for isbn
	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public List<Review> getReviewById(@PathVariable String isbn) {
		return reviewService.findReviewById(isbn);
	}

	// getting reviews in rating range
	@GetMapping("/rating-between/{min}/and/{max}")
	public List<Review> getReviewInRange(@PathVariable("min") int min, @PathVariable("max") int max) {
		return reviewService.getReviewInRange(min, max);
	}

	// getting reviews in containing text
	@GetMapping("/containing/{text}")
	public List<Review> getReviewContainsText(@PathVariable("text") String text) {
		return reviewService.getReviewContainsText(text);
	}

	// getting average rating of given isbn
	@GetMapping("/{isbn}/average-rating")
	public int getAverageRating(@PathVariable("isbn") String isbn) {
		return reviewService.getAverageRating(isbn);
	}
}
