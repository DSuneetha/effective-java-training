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
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// save review for a book
	@PostMapping("/{isbn}")
	public void addReview(@RequestBody Review review,@PathVariable("isbn") String isbn) {
		reviewService.save(review,isbn);
	}

	// get all reviews
	@GetMapping("/")
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	// get all reviews for given isbn
	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public List<Review> getReviewById(@PathVariable String isbn) {
		return reviewService.findReviewById(isbn);
	}

	// get all reviews in min and max rating range
	@GetMapping("/rating-between/{min}/and/{max}")
	public List<Review> getReviewInRange(@PathVariable("min") int min, @PathVariable("max") int max) {
		return reviewService.getReviewInRange(min, max);
	}

	// get all reviews  containing text
	@GetMapping("/containing/{text}")
	public List<Review> getReviewContainsText(@PathVariable("text") String text) {
		return reviewService.getReviewContainsText(text);
	}

	// get average rating of given isbn
	@GetMapping("/{isbn}/average-rating")
	public int getAverageRating(@PathVariable("isbn") String isbn) {
		return reviewService.getAverageRating(isbn);
	}
}
