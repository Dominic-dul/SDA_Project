package com.sda.pos.repository;

import com.sda.pos.model.POSProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<POSProduct, Long> {
}
