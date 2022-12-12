package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrder;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {

    public List<POSOrder> getOrders();

    public void saveOrder(Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId);
}
