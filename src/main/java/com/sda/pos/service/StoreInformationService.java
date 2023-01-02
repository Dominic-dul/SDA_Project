package com.sda.pos.service;

public interface StoreInformationService {
    public void createStoreInformation(String name, String description, String workHours, String address, String contactInfo);
    public void updateStoreInformation(Long storeInformationId, String name, String description, String workHours, String address, String contactInfo);
}
