package io.catalyte.springboot.services;

import io.catalyte.springboot.customExceptions.ResourceNotFound;
import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;
import io.catalyte.springboot.repositories.ReviewRepository;
import io.catalyte.springboot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{


    private final ReviewRepository reviewRepository;
    private final VehicleRepository vehicleRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, VehicleRepository vehicleRepository) {
        this.reviewRepository = reviewRepository;
        this.vehicleRepository = vehicleRepository;
    }

    Optional<Review> review;

    private List<Vehicle> vehicleList;
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public List<Review> GetReviews() {
        try {
            reviewList = reviewRepository.findAll();
            return reviewList;
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public Optional<Review> GetReviewById(Long id) {
        try {
            review = reviewRepository.findById(id);
            return review;
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }


    @Override
    public void AddReview(Review review) {
        try {
            reviewRepository.save(review);

        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public void UpdateReview(Review review) {
        try {
            reviewRepository.save(review);

        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public void DeleteReview(Long id) {
        boolean exists = reviewRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFound("Can't find list");
        }
        reviewRepository.deleteById(id);
    }


    @Override
    public List<Review> GetReviewByVehicleId(Long vehicleId) {
        return null;
    }

    @Override
    public List<Review> GetReviewByMakeAndModel(String make, String model) {
        List<Review> finalList = new ArrayList<>();
        try {
            Vehicle vehicle = vehicleRepository.findByMakeAndModel(make, model);
            reviewList = reviewRepository.findAllByVehicleId(vehicle.getId());
//            Optional<Vehicle> vehicle = vehicleRepository.findByMakeAndModel(make, model);
//
//            reviewList = reviewRepository.findAllByVehicle(vehicle);
            return reviewList;

        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

}
