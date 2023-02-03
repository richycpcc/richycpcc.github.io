package io.catalyte.springboot.data;

import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;
import io.catalyte.springboot.repositories.ReviewRepository;
import io.catalyte.springboot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    private Review review1;
    private Review review2;
    private Review review3;
    private Review review4;

    private Vehicle vehicle1;
    private Vehicle vehicle2;

    @Override
    public void run(String... args) throws Exception {
        loadReviews();
        loadVehicles();
    }

    private void loadVehicles() {
        vehicle1 = vehicleRepository.save(new Vehicle( "car", "Toyota", "Camry", 2017));
        vehicle1 = vehicleRepository.save(new Vehicle( "truck", "Ford", "F-150", 2022));
    }

    private void loadReviews() {
        review1 = reviewRepository.save(new Review("Favorite Car",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna ", 8, "1-1-2022", "carBuff", 1L));

        review2 = reviewRepository.save(new Review("Nice Truck",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna ", 10, "5-17-2021", "truckGuy", 2L));

        review3 = reviewRepository.save(new Review("Hate this Car",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna ", 4, "12-11-2022", "carHater", 1L));

        review4 = reviewRepository.save(new Review("Ok Truck",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna ", 7, "3-21-2021", "BigBoy", 2L));
    }
}
