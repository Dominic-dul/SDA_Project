package com.sda.pos.model;

import com.sda.pos.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class POSOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private Timestamp startDate;
    private Timestamp estimatedEndDate;
    private Timestamp endDate;
    private String moreInfo;
    private OrderStatus orderStatus;
    private String storeUserId;

    public POSOrder(Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId) {
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.endDate = endDate;
        this.moreInfo = moreInfo;
        this.orderStatus = orderStatus;
        this.storeUserId = storeUserId;
    }

    public POSOrder() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public void setEstimatedEndDate(Timestamp estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreUserId() {
        return storeUserId;
    }

    public void setStoreUserId(String storeUserId) {
        this.storeUserId = storeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSOrder order = (POSOrder) o;
        return userId.equals(order.userId) && Objects.equals(startDate, order.startDate) && Objects.equals(estimatedEndDate, order.estimatedEndDate) && Objects.equals(endDate, order.endDate) && Objects.equals(moreInfo, order.moreInfo) && orderStatus == order.orderStatus && Objects.equals(storeUserId, order.storeUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, startDate, estimatedEndDate, endDate, moreInfo, orderStatus, storeUserId);
    }
}
