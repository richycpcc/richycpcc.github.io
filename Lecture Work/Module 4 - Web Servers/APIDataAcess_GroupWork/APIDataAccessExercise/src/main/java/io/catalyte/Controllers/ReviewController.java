package io.catalyte.Controllers;

import io.catalyte.Services.ReviewServiceImpl;
import io.catalyte.Services.VehicleService;
import io.catalyte.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.catalyte.Services.ReviewService;
import io.catalyte.entities.Review;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private VehicleService vehicleService;

//    @GetMapping
//    public List<Review> getAllReviews()
//    {
//        List<Review> retReviews = reviewService.GetVehicle();
//        return retReviews;
//    }
//    @GetMapping(value = "review/{model}")
//    public List<Review>getReviewsForModel(@PathVariable String model)
//    {
//        Vehicle vehicle = vehicleService.GetByModel(model);
//        return reviewService.GetReviewForVehicle(vehicle);
//    }
}
