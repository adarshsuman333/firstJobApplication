package com.demoProject1.firstJobApp.review;

import com.demoProject1.firstJobApp.review.impl.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Long companyId,
                                               @RequestBody Review review) {
        boolean isReviewSaved = reviewService.createReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added successfully.", HttpStatus.OK);
        }
        else  {
            return new ResponseEntity<>("Review could not be saved.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviews(@PathVariable Long companyId,
                                             @PathVariable Long reviewId) {
        return new ResponseEntity<>( reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

}
