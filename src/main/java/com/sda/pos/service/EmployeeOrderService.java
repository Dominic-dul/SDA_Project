package com.sda.pos.service;

import com.sda.pos.model.POSOrder;

import java.util.List;

public interface EmployeeOrderService {
    List<POSOrder> getEmployeeOrdersByEmployeeId(Long employeeId);
}
