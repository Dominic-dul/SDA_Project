package com.sda.pos.repository;

import com.sda.pos.model.POSLoyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyRepository extends JpaRepository<POSLoyalty, Long> {
}
