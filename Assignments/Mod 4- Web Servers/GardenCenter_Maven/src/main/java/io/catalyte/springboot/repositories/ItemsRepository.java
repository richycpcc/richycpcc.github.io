package io.catalyte.springboot.repositories;

import io.catalyte.springboot.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}