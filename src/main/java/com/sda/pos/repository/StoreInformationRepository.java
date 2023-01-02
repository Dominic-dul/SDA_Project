package com.sda.pos.repository;

import com.sda.pos.model.POSStoreInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreInformationRepository extends JpaRepository<POSStoreInformation, Long> {
}
