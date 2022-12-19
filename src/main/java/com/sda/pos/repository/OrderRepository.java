package com.sda.pos.repository;

import com.sda.pos.model.POSOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<POSOrder, Long> {
}
