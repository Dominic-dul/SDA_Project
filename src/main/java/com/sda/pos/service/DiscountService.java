package com.sda.pos.service;

import com.sda.pos.enums.DiscountType;
import com.sda.pos.model.POSDiscount;

import java.util.List;

public interface DiscountService {

    List<POSDiscount> getDiscounts();

    void saveDiscount(Long discountId, Long productId, Double discountPercent, Double discountFlat, DiscountType discountType);

    void updateDiscount(Long discountId, Long productId, Double discountPercent, Double discountFlat, DiscountType discountType);

}
