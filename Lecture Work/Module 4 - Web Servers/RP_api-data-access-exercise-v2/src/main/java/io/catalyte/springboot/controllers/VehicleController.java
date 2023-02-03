package io.catalyte.springboot.controllers;

import io.catalyte.springboot.entities.Vehicle;
import io.catalyte.springboot.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> vehicleList = new ArrayList<>();
    public Optional<Vehicle> vehicleOptional;

    private Vehicle vehicle;

    @GetMapping
    public List<Vehicle> getVehicles() {
        vehicleList = vehicleService.GetVehicles();
        return vehicleList;
    }

    @GetMapping(path = "/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable("id") Long id) {
        vehicleOptional = vehicleService.GetVehicleById(id);
        return vehicleOptional;
    }
    @PutMapping(path = "/{id}")
    public void updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        vehicleService.UpdateVehicle(vehicle);
    }

    @PostMapping
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.AddVehicle(vehicle);
    }
    @GetMapping(path = "/byMakeAndModel")
    public Vehicle GetVehicleByMakeAndModel(@RequestParam String make, String model) {
        vehicle = vehicleService.FindByMakeAndModel(make, model);
        return vehicle;
    }
    @DeleteMapping(path = "/byMakeAndModel")
    public void deleteVehicle(@RequestParam String make, String model) {
        vehicleService.deleteVehicleByMakeAndModel(make, model);
    }

}
