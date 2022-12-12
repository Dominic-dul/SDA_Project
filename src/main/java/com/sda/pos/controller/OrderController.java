package com.sda.pos.controller;

import com.sda.pos.model.POSOrder;
import com.sda.pos.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Orders")
@RequestMapping("/pos/orders")
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

    @Operation(summary = "Post an order")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrder(@RequestBody POSOrder order){
        orderService.saveOrder(order.getStartDate(), order.getEstimatedEndDate(), order.getEndDate(), order.getMoreInfo(), order.getOrderStatus(), order.getStoreUserId());
    }
}
