package com.sda.pos.service;

import com.sda.pos.enums.EmployeeRole;
import com.sda.pos.model.POSEmployee;

public interface EmployeeService {

    POSEmployee getEmployeeByEmployeeId(Long employeeId);

    void saveEmployee(Long employeeId, EmployeeRole employeeRole, Long storeId, String fullName, String address);

    void deleteEmployeeByEmployeeId(Long employeeId);
}
