package io.catalyte.springboot.repositories;

import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT ")
    List<Review> findAllByVehicleMakeAndVehicleModel(String vehicleMake, String vehicleModel);

    List<Review> findAllByVehicleId(Long vehicleId);


}
