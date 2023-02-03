package io.catalyte.repositories;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{

}
