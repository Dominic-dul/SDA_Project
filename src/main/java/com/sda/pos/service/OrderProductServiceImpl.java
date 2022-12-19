package com.sda.pos.service;

import com.sda.pos.enums.OrderStatus;
import com.sda.pos.model.POSOrderProduct;
import com.sda.pos.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    private final OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public void saveOrderProduct(Long productId, Long orderId) {
        POSOrderProduct newOrderProduct = new POSOrderProduct(productId, orderId);
        orderProductRepository.save(newOrderProduct);
    }

    @Override
    public void deleteOrderProduct(Long productId, Long orderId) {
        Long neededOrderProductId = orderProductRepository.findAll().stream()
                .filter(product -> product.getProductId().equals(productId) && product.getOrderId().equals(orderId))
                .findFirst().orElseThrow().getOrderProductId();

        orderProductRepository.deleteById(neededOrderProductId);
    }

    @Override
    public List<POSOrderProduct> getOrderProducts() {
        return orderProductRepository.findAll();
    }
}
