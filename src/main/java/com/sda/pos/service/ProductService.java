package com.sda.pos.service;

import com.sda.pos.model.POSProduct;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<POSProduct> getProducts();

    void saveProduct(Long productId, String name, String description, int quantity, BigDecimal price, String storeUserId);

    void updateProduct(Long productId, String name, String description, int quantity, BigDecimal price, String storeUserId);

    POSProduct getProductByProductId(Long productId);

    void deleteProductByProductId(Long productId);
}
