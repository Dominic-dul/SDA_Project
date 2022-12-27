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
    private long userId;
    private String number;
    private Timestamp startDate;
    private Timestamp expirationDate;
}