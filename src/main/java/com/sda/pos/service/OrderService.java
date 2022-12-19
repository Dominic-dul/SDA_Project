package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrder;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {

    public List<POSOrder> getOrders();

    public void saveOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId);

    public void updateOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId);

    public void updateOrderStatusToConfirmed(Long orderId);

    public OrderStatus getOrderStatus(Long orderId);

    public POSOrder getOrderByUserId(Long userId);

    public List<POSOrder> getCompletedOrders();
}
