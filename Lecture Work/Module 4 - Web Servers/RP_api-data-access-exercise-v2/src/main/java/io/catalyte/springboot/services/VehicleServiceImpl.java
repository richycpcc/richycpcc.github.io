package io.catalyte.springboot.services;

import io.catalyte.springboot.customExceptions.ResourceNotFound;
import io.catalyte.springboot.entities.Review;
import io.catalyte.springboot.entities.Vehicle;
import io.catalyte.springboot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    List<Vehicle> vehicleList = new ArrayList<>();

    Optional<Vehicle> vehicleOptional;

    private Vehicle vehicle;
    @Override
    public List<Vehicle> GetVehicles() {

        try {
            vehicleList = vehicleRepository.findAll();
            return vehicleList;
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public void AddVehicle(Vehicle vehicle) {
        try {
            vehicleRepository.save(vehicle);

        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public void UpdateVehicle(Vehicle vehicle) {
        try {
            vehicleRepository.save(vehicle);
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public void deleteVehicleByMakeAndModel(String make, String model) {
        try {
            vehicle = vehicleRepository.findByMakeAndModel(make, model);
            vehicleRepository.delete(vehicle);
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public Optional<Vehicle> GetVehicleById(Long id) {
        try {
            vehicleOptional = vehicleRepository.findById(id);
            return vehicleOptional;
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }

    @Override
    public Vehicle FindByMakeAndModel(String make, String model) {
        try {
            vehicle = vehicleRepository.findByMakeAndModel(make, model);
            return vehicle;
        } catch (DataAccessException dae) {
            throw new ResourceNotFound("Can't find list");
        }
    }
}
