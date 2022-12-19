package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrder;
import com.sda.pos.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<POSOrder> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId) {
        POSOrder newOrder = new POSOrder(userId, startDate, estimatedEndDate, endDate, moreInfo, orderStatus, storeUserId);
        orderRepository.save(newOrder);
    }

    @Override
    public void updateOrder(Long userId, Timestamp startDate, Timestamp estimatedEndDate, Timestamp endDate, String moreInfo, OrderStatus orderStatus, String storeUserId) {
        if(orderRepository.existsById(userId)){
            orderRepository.deleteById(userId);
        }
        else {
            throw new RuntimeException("Order with this id does not exist");
        }

        POSOrder newOrder = new POSOrder(userId, startDate, estimatedEndDate, endDate, moreInfo, orderStatus, storeUserId);
        newOrder.setUserId(userId);

        orderRepository.save(newOrder);
    }
}
