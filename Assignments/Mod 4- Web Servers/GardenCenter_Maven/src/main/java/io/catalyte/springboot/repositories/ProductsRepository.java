package io.catalyte.springboot.repositories;

import io.catalyte.springboot.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    Boolean existsBySku(String sku);
}
