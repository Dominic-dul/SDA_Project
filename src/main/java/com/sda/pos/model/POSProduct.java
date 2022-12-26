package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class POSProduct {
    @Id
    private Long productId;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private String storeUserId;

    public POSProduct(Long productId, String name, String description, int quantity, BigDecimal price, String storeUserId) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.storeUserId = storeUserId;
        this.productId = productId;
    }

    public POSProduct() {

    }

    public void setProductId(Long id) {
        this.productId = id;
    }


    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStoreUserId() {
        return storeUserId;
    }

    public void setStoreUserId(String storeUserId) {
        this.storeUserId = storeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSProduct order = (POSProduct) o;
        return productId.equals(order.productId)
                && Objects.equals(name, order.name)
                && Objects.equals(description, order.description)
                && Objects.equals(quantity, order.quantity)
                && Objects.equals(storeUserId, order.storeUserId)
                && price.equals(order.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, quantity, storeUserId, price);
    }
}
