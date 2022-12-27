package com.sda.pos.service;

import com.sda.pos.model.POSLoyalty;

import java.sql.Timestamp;
import java.util.List;

public interface LoyaltyService {
    public void saveLoyalty(Long loyaltyInformationId, Long userId, Timestamp startDate, Timestamp expirationDate);
}
