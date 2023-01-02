package com.sda.pos.controller;

import com.sda.pos.model.POSDiscount;
import com.sda.pos.service.DiscountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Discounts")
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Operation(summary = "Get all discounts")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSDiscount> getDiscounts() {
        return discountService.getDiscounts();
    }

    @Operation(summary = "Post a discount")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveDiscount(@RequestBody POSDiscount discount) {
        discountService.saveDiscount(
                discount.getDiscountId(),
                discount.getProductId(),
                discount.getDiscountPercent(),
                discount.getDiscountFlat(),
                discount.getDiscountType()
        );
    }

    @Operation(summary = "Update a discount")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDiscount(@RequestBody POSDiscount discount) {
        discountService.updateDiscount(
                discount.getDiscountId(),
                discount.getProductId(),
                discount.getDiscountPercent(),
                discount.getDiscountFlat(),
                discount.getDiscountType()
        );
    }
}
