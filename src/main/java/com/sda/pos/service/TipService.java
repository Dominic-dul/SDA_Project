package com.sda.pos.service;

import com.sda.pos.model.POSTip;

import java.math.BigDecimal;
import java.util.List;

public interface TipService {

    public void saveTip(BigDecimal amount, Long orderId);

    public List<POSTip> getTips();
}
