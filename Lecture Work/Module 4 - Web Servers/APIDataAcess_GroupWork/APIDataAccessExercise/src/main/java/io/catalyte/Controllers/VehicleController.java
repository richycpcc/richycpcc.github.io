package io.catalyte.Controllers;

import io.catalyte.Services.VehicleService;
import io.catalyte.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController
{
 @Autowired
 private VehicleService vehicleService;
 @GetMapping
    public List<Vehicle> getAllVehicles()
 {
     List<Vehicle> retVehicles = vehicleService.GetVehicles();
     return retVehicles;
 }
}
