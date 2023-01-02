package com.sda.pos.service;

import java.sql.Timestamp;

public interface LoyaltyService {
    public void saveLoyalty(Long loyaltyInformationId, Long userId, Timestamp startDate, Timestamp expirationDate);
}
