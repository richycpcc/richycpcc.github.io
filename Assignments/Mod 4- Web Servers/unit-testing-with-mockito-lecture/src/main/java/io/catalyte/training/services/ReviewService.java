package io.catalyte.training.services;

import io.catalyte.training.domains.Review;

public interface ReviewService {

  Review getReviewById(String id);

  int countReviewsByMakeAndModel(String make, String model);
}