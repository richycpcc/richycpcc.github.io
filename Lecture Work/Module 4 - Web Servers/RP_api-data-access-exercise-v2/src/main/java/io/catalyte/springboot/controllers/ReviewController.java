package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;
import io.catalyte.springboot.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    List<Review> reviewList = new ArrayList<>();

    Optional<Review> review;

    @GetMapping
    public List<Review> getAllReviews() {
         reviewList = reviewService.GetReviews();
        return reviewList;
    }
    @GetMapping(path = "/{id}")
    public Optional<Review> getReviewById(@PathVariable("id") Long id) {
        review = reviewService.GetReviewById(id);
        return review;
    }

    @PostMapping
    public void addReview(@RequestBody Review review) {
        reviewService.AddReview(review);
    }

    @PutMapping(path = "/{id}")
    public void updateReview(@RequestBody Review review, @PathVariable Long id) {
        reviewService.UpdateReview(review);
    }

    @GetMapping(path = "/byMakeAndModel")
    public List<Review> getReviewsByMakeAndModel(@RequestParam String make, String model) {
        reviewList = reviewService.GetReviewByMakeAndModel(make, model);
        return reviewList;
    }
    @DeleteMapping(path = "/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.DeleteReview(id);
    }

}
