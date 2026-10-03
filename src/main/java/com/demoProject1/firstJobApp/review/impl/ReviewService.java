package com.demoProject1.firstJobApp.review.impl;

import com.demoProject1.firstJobApp.review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
}
