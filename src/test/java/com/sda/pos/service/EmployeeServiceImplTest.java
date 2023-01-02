package com.sda.pos.service;

import com.sda.pos.enums.EmployeeRole;
import com.sda.pos.model.POSEmployee;
import com.sda.pos.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private POSEmployee employee;

    @BeforeEach
    public void setup(){
        employee = new POSEmployee(1L, EmployeeRole.EMPLOYEE, 1L, "John Smith", "London st. 1");
    }

    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenRepositorySaveWasInvoked(){
        // given - precondition or setup
        given(employeeRepository.save(employee)).willReturn(employee);

        // when -  action or the behaviour that we are going test
        employeeService.saveEmployee(
                employee.getEmployeeId(),
                employee.getEmployeeRole(),
                employee.getStoreId(),
                employee.getFullName(),
                employee.getAddress()
        );

        // then - verify the output
        verify(employeeRepository, times(1)).save(employee);
    }

    @DisplayName("JUnit test for getEmployeeByEmployeeId method")
    @Test
    public void givenEmployeeId_whenGetEmployeeByEmployeeId_thenReturnProductObject(){
        // given
        given(employeeRepository.findById(employee.getEmployeeId())).willReturn(Optional.ofNullable(employee));

        // when
        POSEmployee newEmployee = employeeService.getEmployeeByEmployeeId(employee.getEmployeeId());

        // then
        assertThat(newEmployee).isNotNull();
    }

    @DisplayName("JUnit test for deleteEmployeeByEmployeeId method")
    @Test
    public void givenEmployeeId_whenDeleteEmployeeByEmployeeId_thenRepositoryDeleteWasInvoked (){
        // given
        given(employeeRepository.existsById(employee.getEmployeeId())).willReturn(true);

        // when
        employeeService.deleteEmployeeByEmployeeId(employee.getEmployeeId());

        // then - verify the output
        verify(employeeRepository, times(1)).existsById(employee.getEmployeeId());
        verify(employeeRepository, times(1)).deleteById(employee.getEmployeeId());
    }
}
