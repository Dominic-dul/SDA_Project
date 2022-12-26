package com.sda.pos.model;
import java.util.Objects;

public class POSRefundCreate {
    private Long userId;
    private Long orderId;
    private String name;
    private String description;

    public POSRefundCreate() {

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

    @Override
    public int hashCode() {
        return Objects.hash(userId, orderId, name, description);
    }
}
