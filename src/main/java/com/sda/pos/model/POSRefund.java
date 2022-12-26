package com.sda.pos.model;

import com.sda.pos.enums.RefundStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class POSRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    private Long userId;
    private Long orderId;
    private String name;
    private String description;
    private RefundStatus status;
    private String supportUserId;

    public POSRefund(Long userId, Long orderId, String name, String description) {
        this.userId = userId;
        this.orderId = orderId;
        this.name = name;
        this.description = description;

        this.status = RefundStatus.CREATED;
        this.supportUserId = "0";
    }

    public POSRefund() {

    }


    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


    public Long getRequestId() {
        return requestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }

    public String getSupportUserId() {
        return supportUserId;
    }

    public void setSupportUserId(String supportUserId) {
        this.supportUserId = supportUserId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSRefund refund = (POSRefund) o;
        return requestId == refund.requestId
                && userId.equals(refund.userId)
                && orderId.equals(refund.orderId)
                && Objects.equals(name, refund.name)
                && Objects.equals(description, refund.description)
                && Objects.equals(status, refund.status)
                && Objects.equals(supportUserId, refund.supportUserId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(requestId, userId, orderId, name, description, status, supportUserId);
    }
}
