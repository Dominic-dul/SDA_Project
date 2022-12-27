package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSLoyaltyInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyaltyInformationId;
    private String information;
    private String requirements;

    public Long getLoyaltyInformationId() {
        return loyaltyInformationId;
    }

    public String getInformation() {
        return information;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setLoyaltyInformationId(Long loyaltyInformationId) {
        this.loyaltyInformationId = loyaltyInformationId;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSLoyaltyInformation that = (POSLoyaltyInformation) o;
        return Objects.equals(loyaltyInformationId, that.loyaltyInformationId) && Objects.equals(information, that.information) && Objects.equals(requirements, that.requirements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyInformationId, information, requirements);
    }
}
