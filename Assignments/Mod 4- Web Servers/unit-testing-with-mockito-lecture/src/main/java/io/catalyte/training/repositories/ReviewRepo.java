package io.catalyte.training.repositories;

import io.catalyte.training.domains.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<Review, String> {

  int countByVehicleId(ObjectId vehicleId);
}
