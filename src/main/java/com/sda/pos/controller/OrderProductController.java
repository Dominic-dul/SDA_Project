package com.sda.pos.controller;

import com.sda.pos.model.POSOrderProduct;
import com.sda.pos.service.OrderProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Orders Products")
@RequestMapping("/orders/product")
public class OrderProductController {

    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @Operation(summary = "Create new order product")
    @PostMapping(value = "/{productId}/{orderId}")
    public void createOrderProduct(@PathVariable("productId") Long productId, @PathVariable("orderId") Long orderId){
        orderProductService.saveOrderProduct(productId, orderId);
    }

    @Operation(summary = "Delete order product")
    @DeleteMapping(value = "/{productId}/{orderId}")
    public void deleteOrderProduct(@PathVariable("productId") Long productId, @PathVariable("orderId") Long orderId){
        orderProductService.deleteOrderProduct(productId, orderId);
    }

    @Operation(summary = "Get all order products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSOrderProduct> getOrderProducts(){
        return orderProductService.getOrderProducts();
    }
}
