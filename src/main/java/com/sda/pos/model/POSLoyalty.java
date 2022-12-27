package com.sda.pos.model;

import com.sda.pos.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class POSLoyalty {
    @Id
    private Long userId;
    private String number;
    private Timestamp startDate;
    private Timestamp expirationDate;

    public POSLoyalty() {
    }

    public POSLoyalty(Long userId, String number, Timestamp startDate, Timestamp expirationDate){
        this.userId = userId;
        this.number = number;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNumber() {
        return number;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POSLoyalty that = (POSLoyalty) o;
        return Objects.equals(userId, that.userId) && Objects.equals(number, that.number) && Objects.equals(startDate, that.startDate) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, number, startDate, expirationDate);
    }
}