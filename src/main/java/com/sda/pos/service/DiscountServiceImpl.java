package com.sda.pos.service;

import com.sda.pos.enums.DiscountType;
import com.sda.pos.model.POSDiscount;
import com.sda.pos.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<POSDiscount> getDiscounts() {
        return discountRepository.findAll();
    }

    @Override
    public void saveDiscount(Long discountId, Long productId, Double discountPercent, Double discountFlat, DiscountType discountType) {
        POSDiscount newDiscount = new POSDiscount(discountId, productId, discountPercent, discountFlat, discountType);
        discountRepository.save(newDiscount);
    }

    @Override
    public void updateDiscount(Long discountId, Long productId, Double discountPercent, Double discountFlat, DiscountType discountType) {
        if(discountRepository.existsById(discountId)){

            POSDiscount newDiscount = new POSDiscount(discountId, productId, discountPercent, discountFlat, discountType);
            newDiscount.setDiscountId(discountId);

            discountRepository.save(newDiscount);
        }
        else {
            throw new NoSuchElementException("Discount with this id does not exist");
        }
    }
}
