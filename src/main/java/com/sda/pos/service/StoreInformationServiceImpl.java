package com.sda.pos.service;

import com.sda.pos.model.POSStoreInformation;
import com.sda.pos.repository.StoreInformationRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StoreInformationServiceImpl implements StoreInformationService{
    private final StoreInformationRepository storeInformationRepository;

    public StoreInformationServiceImpl(StoreInformationRepository storeInformationRepository) {
        this.storeInformationRepository = storeInformationRepository;
    }

    @Override
    public void createStoreInformation(String name, String description, String workHours, String address, String contactInfo) {
        POSStoreInformation newStoreInformation = new POSStoreInformation(name, description, workHours, address, contactInfo);
        storeInformationRepository.save(newStoreInformation);
    }

    @Override
    public void updateStoreInformation(Long storeInformationId, String name, String description, String workHours, String address, String contactInfo) {
        if(storeInformationRepository.existsById(storeInformationId)){
            POSStoreInformation newStoreInformation = storeInformationRepository.findById(storeInformationId).orElseThrow();
            newStoreInformation.setName(name);
            newStoreInformation.setDescription(description);
            newStoreInformation.setWorkHours(workHours);
            newStoreInformation.setAddress(address);
            newStoreInformation.setContactInfo(contactInfo);
            storeInformationRepository.save(newStoreInformation);
        }
        else {
            throw new NoSuchElementException("Store Information with this id does not exist");
        }
    }
}
