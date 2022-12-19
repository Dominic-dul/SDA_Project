package com.sda.pos.controller;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrder;
import com.sda.pos.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Orders")
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Get all orders")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSOrder> getOrders(){
        return orderService.getOrders();
    }

    @Operation(summary = "Get order status by userId")
    @GetMapping(value = "/{userId}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderStatus getOrderStatus(@PathVariable("userId") Long userId){
        return orderService.getOrderStatus(userId);
    }

    @Operation(summary = "Get all finished orders")
    @GetMapping(value = "/completed", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSOrder> getCompletedOrders(){
        return orderService.getCompletedOrders();
    }

    @Operation(summary = "Get order by userId")
    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public POSOrder getOrderByUserId(@PathVariable("userId") Long userId){
        return orderService.getOrderByUserId(userId);
    }

    @Operation(summary = "Post an order")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrder(@RequestBody POSOrder order){
        orderService.saveOrder(order.getUserId(), order.getStartDate(), order.getEstimatedEndDate(), order.getEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId());
    }

    @Operation(summary = "Update an order")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody POSOrder order){
        orderService.updateOrder(order.getUserId(), order.getStartDate(), order.getEstimatedEndDate(), order.getEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId());
    }

    @Operation(summary = "Update order status to PLACED")
    @PutMapping(value = "/{userId}/confirm")
    public void updateOrderStatusToConfirmed(@PathVariable("userId") Long orderId){
        orderService.updateOrderStatusToConfirmed(orderId);
    }
}
