package io.catalyte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.catalyte.entities.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>
{
}
