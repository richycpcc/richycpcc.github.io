package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> GetReviews();

    Optional<Review> GetReviewById(Long id);

    void AddReview(Review review);

    void UpdateReview(Review review);

    void DeleteReview(Long id);

    List<Review> GetReviewByVehicleId(Long vehicleId);

    List<Review> GetReviewByMakeAndModel(String make, String model);

}
