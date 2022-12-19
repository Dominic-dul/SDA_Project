package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrderProduct;

import java.util.List;

public interface OrderProductService {

    public void saveOrderProduct(Long productId, Long orderId);

    public void deleteOrderProduct(Long productId, Long orderId);

    public List<POSOrderProduct> getOrderProducts();
}
