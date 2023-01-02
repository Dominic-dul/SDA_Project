package com.sda.pos.service;

import com.sda.pos.enums.EmployeeRole;
import com.sda.pos.model.POSEmployee;
import com.sda.pos.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public POSEmployee getEmployeeByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public void saveEmployee(Long employeeId, EmployeeRole employeeRole, Long storeId, String fullName, String address) {

    }

    @Override
    public void deleteEmployeeByEmployeeId(Long employeeId) {

    }
}
