package com.sda.pos.service;

import com.sda.pos.enums.EmployeeRole;
import com.sda.pos.model.POSEmployee;
import com.sda.pos.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public POSEmployee getEmployeeByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    @Override
    public void saveEmployee(Long employeeId, EmployeeRole employeeRole, Long storeId, String fullName, String address) {
        POSEmployee newEmployee = new POSEmployee(employeeId, employeeRole, storeId, fullName, address);
        employeeRepository.save(newEmployee);
    }

    @Override
    public void deleteEmployeeByEmployeeId(Long employeeId) {
        if(employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
        }
        else {
            throw new NoSuchElementException("Employee with this id does not exist");
        }
    }
}
