package com.sda.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class POSTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipId;
    private BigDecimal amount;
    private Long orderId;

    public POSTip(BigDecimal amount, Long orderId) {
        this.amount = amount;
        this.orderId = orderId;
    }

    public POSTip() {

    }

    public Long getTipId() {
        return tipId;
    }

    public void setTipId(Long tipId) {
        this.tipId = tipId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSTip posTip = (POSTip) o;
        return Objects.equals(tipId, posTip.tipId) && Objects.equals(amount, posTip.amount) && Objects.equals(orderId, posTip.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipId, amount, orderId);
    }
}
