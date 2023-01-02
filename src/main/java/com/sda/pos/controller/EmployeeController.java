package com.sda.pos.controller;

import com.sda.pos.model.POSEmployee;
import com.sda.pos.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Employees")
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Post an employee")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveEmployee(@RequestBody POSEmployee employee) {
        employeeService.saveEmployee(
                employee.getEmployeeId(),
                employee.getEmployeeRole(),
                employee.getStoreId(),
                employee.getFullName(),
                employee.getAddress()
        );
    }

    @Operation(summary = "Delete employee by employeeId")
    @DeleteMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployeeByEmployeeId(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployeeByEmployeeId(employeeId);
    }

    @Operation(summary = "Get employee by employeeId")
    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public POSEmployee getEmployeeByEmployeeId(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }
}
