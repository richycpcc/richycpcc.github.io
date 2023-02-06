package io.catalyte.training.controllers;

import io.catalyte.training.domains.Review;
import io.catalyte.training.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  /**
   * Calls the service to retrieve a review matching the given id, if found.
   *
   * @param id the id of the review to search for
   * @return the review with the given id
   */
  @GetMapping(value = "/{id}")
  public Review getReviewById(@PathVariable String id) {
    return reviewService.getReviewById(id);
  }

  /**
   * Calls the service to count all the reviews for a given make and model.
   *
   * @param make  the make of the vehicle
   * @param model the model of the vehicle
   * @return the number of reviews for the given make and model
   */
  @GetMapping(value = "/make/{make}/model/{model}/count")
  public int countReviewsByMakeAndModel(@PathVariable String make, @PathVariable String model) {
    return reviewService.countReviewsByMakeAndModel(make, model);
  }

}
