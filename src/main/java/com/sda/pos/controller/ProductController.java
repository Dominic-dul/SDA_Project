package com.sda.pos.controller;

import com.sda.pos.model.POSProduct;
import com.sda.pos.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Products")
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<POSProduct> getProducts(){
        return productService.getProducts();
    }


    @Operation(summary = "Get product by productId")
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public POSProduct getProductByProductId(@PathVariable("productId") Long productId){
        return productService.getProductByProductId(productId);
    }

    @Operation(summary = "Post a product")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(@RequestBody POSProduct product){
        productService.saveProduct(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getStoreUserId()
        );
    }

    @Operation(summary = "Update a product")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody POSProduct product){
        productService.updateProduct(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getStoreUserId()
        );
    }

    @Operation(summary = "Delete product by productId")
    @DeleteMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductByProductId(@PathVariable("productId") Long productId){
        productService.deleteProductByProductId(productId);
    }
}
