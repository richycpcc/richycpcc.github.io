package io.catalyte.training.services;

import static io.catalyte.training.constants.StringConstants.SERVER_ERROR_MESSAGE;

import io.catalyte.training.domains.Review;
import io.catalyte.training.domains.Vehicle;
import io.catalyte.training.exceptions.ServerError;
import io.catalyte.training.repositories.ReviewRepo;
import io.catalyte.training.repositories.VehicleRepo;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepo reviewRepo;
  private final VehicleRepo vehicleRepo;

  @Autowired
  public ReviewServiceImpl(ReviewRepo reviewRepo, VehicleRepo vehicleRepo) {
    this.reviewRepo = reviewRepo;
    this.vehicleRepo = vehicleRepo;
  }

  /**
   * Retrieves the review that has the given id.
   *
   * @param id the id of the review to be returned
   * @return a Review object with the given id
   */
  @Override
  public Review getReviewById(String id) {
    try {
      return reviewRepo.findById(id).orElse(null);
    } catch (DataAccessResourceFailureException e) {
      throw new ServerError(SERVER_ERROR_MESSAGE);
    }
  }

  /**
   * Counts the number of reviews of vehicles with the given make and model.
   *
   * @param make  the make of the vehicles to count reviews of
   * @param model the model of the vehicles to count reviews of
   * @return an int of the number of reviews of vehicles with the given make and model
   */
  @Override
  public int countReviewsByMakeAndModel(String make, String model) {
    try {
      int numberOfReviews = 0;
      List<Vehicle> vehicles = vehicleRepo.findByMakeAndModel(make, model);
      for (Vehicle vehicle : vehicles) {
        numberOfReviews += reviewRepo.countByVehicleId((new ObjectId(vehicle.getId())));
      }
      return numberOfReviews;
    } catch (DataAccessResourceFailureException e) {
      throw new ServerError(SERVER_ERROR_MESSAGE);
    }
  }
}
