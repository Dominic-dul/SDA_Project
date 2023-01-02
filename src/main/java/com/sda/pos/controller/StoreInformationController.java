package com.sda.pos.controller;

import com.sda.pos.model.POSStoreInformation;
import com.sda.pos.service.StoreInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "System")
@RequestMapping("/store-information")
public class StoreInformationController {
    private final StoreInformationService storeInformationService;

    public StoreInformationController(StoreInformationService storeInformationService) {
        this.storeInformationService = storeInformationService;
    }

    @Operation(summary = "Create a store")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createStoreInformation(@RequestBody POSStoreInformation store){
        storeInformationService.createStoreInformation(store.getName(), store.getDescription(), store.getWorkHours(), store.getAddress(), store.getContactInfo());
    }

    @Operation(summary = "Update a store")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStoreInformation(@RequestBody POSStoreInformation store){
        storeInformationService.updateStoreInformation(store.getStoreInformationId(), store.getName(), store.getDescription(), store.getWorkHours(), store.getAddress(), store.getContactInfo());
    }
}
