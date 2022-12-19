package com.sda.pos.repository;

import com.sda.pos.model.POSOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<POSOrderProduct, Long> {
}
