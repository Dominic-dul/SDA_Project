package com.sda.pos.controller;

import com.sda.pos.model.POSLoyaltyInformation;
import com.sda.pos.service.LoyaltyInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Loyalty Information")
@RequestMapping("/loyalty/information")
public class LoyaltyInformationController {
    private final LoyaltyInformationService loyaltyInformationService;

    public LoyaltyInformationController(LoyaltyInformationService loyaltyInformationService) {
        this.loyaltyInformationService = loyaltyInformationService;
    }

    @Operation(summary = "Get all loyalties information")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSLoyaltyInformation> getLoyaltiesInformation(){
        return loyaltyInformationService.getLoyaltiesInformation();
    }

    @Operation(summary = "Create a loyalty information")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrder(@RequestBody POSLoyaltyInformation loyaltyInformation){
        loyaltyInformationService.saveLoyaltyInformation(loyaltyInformation.getInformation(), loyaltyInformation.getRequirements());
    }
}
