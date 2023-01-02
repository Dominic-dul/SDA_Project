package com.sda.pos.repository;

import com.sda.pos.model.POSLoyaltyInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyInformationRepository extends JpaRepository<POSLoyaltyInformation, Long> {
}
