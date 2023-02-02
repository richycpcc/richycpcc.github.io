package io.catalyte.Data;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import io.catalyte.repositories.ReviewRepository;
import io.catalyte.repositories.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner
{
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    private Vehicle vehicle1;
    private Vehicle vehicle2;

    private Review review1;

    @Override
    public void run(String...Strings) throws Exception
    {
       logger.info("loading data...");
       loadVehicles();
       loadPlayers();
    }
    private void loadVehicles()
    {
    vehicle1 = vehicleRepository.save(new Vehicle(1L,"Subcompact car","BMW","250 Isetta",1995));
    vehicle2 = vehicleRepository.save(new Vehicle(2L,"Subcompact car","BMW","600",1957));

    }
    private void loadPlayers()
    {
    review1 = reviewRepository.save(new Review("The Good 1","Need to Buy 1",5, "2002-10-02","rphong"));
    }


}
