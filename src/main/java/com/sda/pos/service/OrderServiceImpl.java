package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSEmployeeOrder;
import com.sda.pos.model.POSOrder;
import com.sda.pos.repository.EmployeeOrderRepository;
import com.sda.pos.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final EmployeeOrderRepository employeeOrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, EmployeeOrderRepository employeeOrderRepository) {
        this.orderRepository = orderRepository;
        this.employeeOrderRepository = employeeOrderRepository;
    }

    @Override
    public List<POSOrder> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId) {
        POSOrder newOrder = new POSOrder(userId, startDate, estimatedEndDate, endDate, moreInfo, orderStatus, storeUserId);
        orderRepository.save(newOrder);
        POSEmployeeOrder employeeOrder = new POSEmployeeOrder(Long.parseLong(storeUserId), userId);
        employeeOrderRepository.save(employeeOrder);
    }

    @Override
    public void updateOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId) {
        if(orderRepository.existsById(userId)){
            POSOrder newOrder = orderRepository.findById(userId).orElseThrow();
            newOrder.setStartDate(startDate);
            newOrder.setEstimatedEndDate(estimatedEndDate);
            newOrder.setEndDate(endDate);
            newOrder.setMoreInfo(moreInfo);
            newOrder.setOrderStatus(orderStatus);
            newOrder.setStoreUserId(storeUserId);
            orderRepository.save(newOrder);
        }
        else {
            throw new NoSuchElementException("Order with this id does not exist");
        }
    }

    @Override
    public void updateOrderStatusToConfirmed(Long orderId) {

        if(orderRepository.existsById(orderId)){
            POSOrder newOrder = orderRepository.findById(orderId).orElseThrow();
            newOrder.setOrderStatus(OrderStatus.PLACED);
            orderRepository.save(newOrder);
        }
        else {
            throw new NoSuchElementException("Order with this id does not exist");
        }
    }

    @Override
    public OrderStatus getOrderStatus(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow().getOrderStatus();
    }

    @Override
    public POSOrder getOrderByUserId(Long userId) {
        return orderRepository.findById(userId).orElseThrow();
    }

    @Override
    public List<POSOrder> getCompletedOrders() {
        return orderRepository.findAll().stream()
                .filter(order -> order.getOrderStatus().equals(OrderStatus.FINISHED))
                .toList();
    }
}
