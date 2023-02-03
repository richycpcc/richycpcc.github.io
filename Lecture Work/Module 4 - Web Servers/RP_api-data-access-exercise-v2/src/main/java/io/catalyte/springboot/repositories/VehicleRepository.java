package io.catalyte.springboot.repositories;

import io.catalyte.springboot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByMakeAndModel(String make, String model);

}
