package com.sda.pos.repository;

import com.sda.pos.model.POSTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipRepository extends JpaRepository<POSTip, Long> {
}
