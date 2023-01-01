package com.sda.pos.model;

import com.sda.pos.enums.DiscountType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSDiscount {
    @Id
    private Long discountId;
    private Long productId;
    private Double discountPercent;
    private Double discountFlat;
    private DiscountType discountType;

    public POSDiscount(Long discountId, Long productId, Double discountPercent, Double discountFlat, DiscountType discountType) {
        this.discountId = discountId;
        this.productId = productId;
        this.discountPercent = discountPercent;
        this.discountFlat = discountFlat;
        this.discountType = DiscountType.NORMAL;
    }

    public POSDiscount() {

    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDiscountFlat() {
        return discountFlat;
    }

    public void setDiscountFlat(Double discountFlat) {
        this.discountFlat = discountFlat;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSDiscount that = (POSDiscount) o;
        return Objects.equals(discountId, that.discountId) && Objects.equals(productId, that.productId) && Objects.equals(discountPercent, that.discountPercent) && Objects.equals(discountFlat, that.discountFlat) && discountType == that.discountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, productId, discountPercent, discountFlat, discountType);
    }
}
