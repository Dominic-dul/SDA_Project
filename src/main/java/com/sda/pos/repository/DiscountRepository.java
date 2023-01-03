package com.sda.pos.repository;

import com.sda.pos.model.POSDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<POSDiscount, Long> {
}
