package io.catalyte.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.catalyte.springboot.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long>{
    Boolean existsByEmail(String email);
}
