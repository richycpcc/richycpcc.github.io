package io.catalyte.training.repositories;

import io.catalyte.training.domains.Vehicle;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepo extends MongoRepository<Vehicle, String> {

  List<Vehicle> findByMakeAndModel(String make, String model);

  boolean existsById(String id);
}
