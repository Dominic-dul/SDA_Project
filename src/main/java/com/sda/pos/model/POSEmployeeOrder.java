package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSEmployeeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeOrderId;
    private Long employeeId;
    private Long orderId;

    public POSEmployeeOrder(Long employeeId, Long orderId) {
        this.employeeId = employeeId;
        this.orderId = orderId;
    }

    public POSEmployeeOrder() {

    }

    public Long getEmployeeOrderId() {
        return employeeOrderId;
    }

    public void setEmployeeOrderId(Long employeeOrderId) {
        this.employeeOrderId = employeeOrderId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSEmployeeOrder that = (POSEmployeeOrder) o;
        return Objects.equals(employeeOrderId, that.employeeOrderId) && Objects.equals(employeeId, that.employeeId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeOrderId, employeeId, orderId);
    }
}
