package com.sda.pos.repository;

import com.sda.pos.model.POSRefund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<POSRefund, Long> {
}
