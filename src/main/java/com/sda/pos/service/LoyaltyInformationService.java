package com.sda.pos.service;

import com.sda.pos.model.POSLoyaltyInformation;
import java.util.List;

public interface LoyaltyInformationService {
    public List<POSLoyaltyInformation> getLoyaltiesInformation();
    public void saveLoyaltyInformation(String information, String requirements);
}
