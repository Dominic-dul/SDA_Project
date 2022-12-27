package com.sda.pos.controller;

import com.sda.pos.model.POSLoyalty;
import com.sda.pos.model.POSOrder;
import com.sda.pos.service.LoyaltyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Loyalty")
@RequestMapping("/loyalty")

public class LoyaltyController {
    private final LoyaltyService loyaltyService;

    public LoyaltyController(com.sda.pos.service.LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }
    @Operation(summary = "Create a Loyalty")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveLoyalty(@RequestBody POSLoyalty loyalty){
        loyaltyService.saveLoyalty(loyalty.getLoyaltyInformationId(), loyalty.getLoyaltyInformationId(), loyalty.getStartDate(), loyalty.getExpirationDate());
    }
}
