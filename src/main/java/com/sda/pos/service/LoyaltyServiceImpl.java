package com.sda.pos.service;

import com.sda.pos.model.POSLoyalty;
import com.sda.pos.repository.LoyaltyRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Service
public class LoyaltyServiceImpl implements LoyaltyService{
    private final LoyaltyRepository loyaltyRepository;

    public LoyaltyServiceImpl(LoyaltyRepository loyaltyRepository) {
        this.loyaltyRepository = loyaltyRepository;
    }

    @Override
    public void saveLoyalty(Long loyaltyInformationId, Long userId, Timestamp startDate, Timestamp expirationDate) {
        POSLoyalty newLoyalty = new POSLoyalty(loyaltyInformationId, userId, startDate, expirationDate);
        loyaltyRepository.save(newLoyalty);
    }
}
