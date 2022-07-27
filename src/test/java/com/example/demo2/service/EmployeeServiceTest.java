package com.example.demo2.service;

import com.example.demo2.Entity.Employee;
import com.example.demo2.Repoasitory.EmployeeRepository;
import com.example.demo2.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void should_return_all_employees_when_call_api_given_service() {
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(newEmployee);

        given(employeeRepository.findAll()).willReturn(employees);

        //when
        List<Employee> result = employeeService.findAll();


        //then
        assertThat(result, hasSize(1));
        assertThat(result.get(0), equalTo(newEmployee));
    }

}
