package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class POSLoyalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyaltyId;
    private Long loyaltyInformationId;
    private Long userId;
    private Timestamp startDate;
    private Timestamp expirationDate;

    public POSLoyalty() {
    }

    public POSLoyalty(Long loyaltyId, Long loyaltyInformationId, Long userId, Timestamp startDate, Timestamp expirationDate){
        this.loyaltyId = loyaltyId;
        this.loyaltyInformationId = loyaltyInformationId;
        this.userId = userId;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Long getLoyaltyId() {
        return loyaltyId;
    }

    public Long getLoyaltyInformationId() {
        return loyaltyInformationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setLoyaltyId(Long loyaltyId) {
        this.loyaltyId = loyaltyId;
    }

    public void setLoyaltyInformationId(Long loyaltyInformationId) {
        this.loyaltyInformationId = loyaltyInformationId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSLoyalty that = (POSLoyalty) o;
        return Objects.equals(loyaltyId, that.loyaltyId) && Objects.equals(loyaltyInformationId, that.loyaltyInformationId) && Objects.equals(userId, that.userId) && Objects.equals(startDate, that.startDate) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyId, loyaltyInformationId, userId, startDate, expirationDate);
    }
}