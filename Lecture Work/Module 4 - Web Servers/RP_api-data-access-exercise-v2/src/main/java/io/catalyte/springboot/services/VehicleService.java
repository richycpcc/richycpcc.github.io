package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> GetVehicles();

    void AddVehicle(Vehicle vehicle);

    void UpdateVehicle(Vehicle vehicle);

    void deleteVehicleByMakeAndModel(String make, String model);

    Optional<Vehicle> GetVehicleById(Long id);

    Vehicle FindByMakeAndModel(String make, String model);
}
