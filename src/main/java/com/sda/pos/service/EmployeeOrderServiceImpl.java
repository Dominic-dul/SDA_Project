package com.sda.pos.service;

import com.sda.pos.model.POSEmployeeOrder;
import com.sda.pos.model.POSOrder;
import com.sda.pos.repository.EmployeeOrderRepository;
import com.sda.pos.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeOrderServiceImpl implements EmployeeOrderService {

    private final EmployeeOrderRepository employeeOrderRepository;
    private final OrderRepository orderRepository;

    public EmployeeOrderServiceImpl(EmployeeOrderRepository employeeOrderRepository, OrderRepository orderRepository) {
        this.employeeOrderRepository = employeeOrderRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<POSOrder> getEmployeeOrdersByEmployeeId(Long employeeId) {
        List<Long> employeeOrderIds = employeeOrderRepository.findAll().stream()
                .filter(empOrd -> empOrd.getEmployeeId().equals(employeeId)).map(POSEmployeeOrder::getOrderId).toList();
        employeeOrderIds.forEach(System.out::println);
        return orderRepository.findAll().stream().filter(order -> employeeOrderIds.contains(Long.parseLong(order.getStoreUserId()))).collect(Collectors.toList());
    }
}
