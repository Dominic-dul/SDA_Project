package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String description;
    private String workHours;
    private String address;
    private String contactInfo;

    public POSClient() {
    }

    public POSClient(String name, String description, String workHours, String address, String contactInfo) {
        this.name = name;
        this.description = description;
        this.workHours = workHours;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
        POSClient posClient = (POSClient) o;
        return Objects.equals(name, posClient.name) && Objects.equals(description, posClient.description) && Objects.equals(workHours, posClient.workHours) && Objects.equals(address, posClient.address) && Objects.equals(contactInfo, posClient.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, workHours, address, contactInfo);
    }
}
