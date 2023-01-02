package com.sda.pos.repository;

import com.sda.pos.model.POSClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<POSClient, Long> {
}
