package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSStoreInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeInformationId;
    private String name;
    private String description;
    private String workHours;
    private String address;
    private String contactInfo;

    public POSStoreInformation() {
    }

    public POSStoreInformation(String name, String description, String workHours, String address, String contactInfo) {
        this.name = name;
        this.description = description;
        this.workHours = workHours;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public POSStoreInformation(Long storeInformationId, String name, String description, String workHours, String address, String contactInfo) {
        this.storeInformationId = storeInformationId;
        this.name = name;
        this.description = description;
        this.workHours = workHours;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public Long getStoreInformationId() {
        return storeInformationId;
    }

    public void setStoreInformationId(Long storeInformationId) {
        this.storeInformationId = storeInformationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSStoreInformation that = (POSStoreInformation) o;
        return Objects.equals(storeInformationId, that.storeInformationId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(workHours, that.workHours) && Objects.equals(address, that.address) && Objects.equals(contactInfo, that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeInformationId, name, description, workHours, address, contactInfo);
    }
}
