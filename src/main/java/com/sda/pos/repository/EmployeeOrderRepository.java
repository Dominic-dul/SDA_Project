package com.sda.pos.repository;

import com.sda.pos.model.POSEmployeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeOrderRepository extends JpaRepository<POSEmployeeOrder, Long> {
}
