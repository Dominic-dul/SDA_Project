package com.sda.pos.model;

import com.sda.pos.enums.EmployeeRole;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class POSEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private EmployeeRole employeeRole;
    private Long storeId;
    private String fullName;
    private String address;

    public POSEmployee(Long employeeId, EmployeeRole employeeRole, Long storeId, String fullName, String address) {
        this.employeeId = employeeId;
        this.employeeRole = EmployeeRole.EMPLOYEE;
        this.storeId = storeId;
        this.fullName = fullName;
        this.address = address;
    }

    public POSEmployee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSEmployee that = (POSEmployee) o;
        return Objects.equals(employeeId, that.employeeId) && employeeRole == that.employeeRole && Objects.equals(storeId, that.storeId) && Objects.equals(fullName, that.fullName) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeRole, storeId, fullName, address);
    }
}
