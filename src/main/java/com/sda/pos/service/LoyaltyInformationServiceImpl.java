package com.sda.pos.service;

import com.sda.pos.model.POSLoyaltyInformation;
import com.sda.pos.repository.LoyaltyInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoyaltyInformationServiceImpl implements LoyaltyInformationService{
    private final LoyaltyInformationRepository loyaltyInformationRepository;

    public LoyaltyInformationServiceImpl(LoyaltyInformationRepository loyaltyInformationRepository) {
        this.loyaltyInformationRepository = loyaltyInformationRepository;
    }

    @Override
    public List<POSLoyaltyInformation> getLoyaltiesInformation() {
        return loyaltyInformationRepository.findAll();
    }

    @Override
    public void saveLoyaltyInformation(String information, String requirements) {
        POSLoyaltyInformation newLoyaltyInformation = new POSLoyaltyInformation(information, requirements);
        loyaltyInformationRepository.save(newLoyaltyInformation);
    }
}
