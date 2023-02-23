package io.catalyte.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.catalyte.springboot.entities.Customers;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    List<Customers> findByAddress_street(String street);

    boolean existsByEmail(String email);
}
