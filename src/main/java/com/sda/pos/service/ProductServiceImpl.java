package com.sda.pos.service;

import com.sda.pos.model.POSProduct;
import com.sda.pos.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<POSProduct> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Long productId, String name, String description, int quantity, BigDecimal price, String storeUserId) {
        POSProduct newProduct = new POSProduct(productId, name, description, quantity, price, storeUserId);
        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(Long productId, String name, String description, int quantity, BigDecimal price, String storeUserId) {
        if(productRepository.existsById(productId)){

            POSProduct newProduct = new POSProduct(productId, name, description, quantity, price, storeUserId);
            newProduct.setProductId(productId);

            productRepository.save(newProduct);
        }
        else {
            throw new NoSuchElementException("Product with this id does not exist");
        }

    }

    @Override
    public POSProduct getProductByProductId(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public void deleteProductByProductId(Long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
        else {
            throw new NoSuchElementException("Product with this id does not exist");
        }
    }


}
