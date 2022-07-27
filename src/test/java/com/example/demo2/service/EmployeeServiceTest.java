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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void should_return_employee_when_call_service_find_by_id_method_given_service() {
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);

        given(employeeRepository.findById(1)).willReturn(newEmployee);

        //when
        Employee result = employeeService.findById(1);


        //then
        assertThat(result.getName(), equalTo("Evan"));
    }

    @Test
    public void should_return_employees_when_call_service_find_by_gender_method_given_service(){
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(newEmployee);

        given(employeeRepository.findByGender("F")).willReturn(employees);

        //when
        List<Employee> result = employeeService.findByGender("F");


        //then
        assertThat(result.get(0).getName(), equalTo("Evan"));
    }

    @Test
    public void should_return_employees_when_call_service_find_by_page_method_given_service() {
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(newEmployee);

        given(employeeRepository.findAllEmployeeByPage(1,1)).willReturn(employees);

        //when
        List<Employee> result = employeeService.findAllEmployeeByPage(1,1);


        //then
        assertThat(result.get(0).getName(), equalTo("Evan"));
    }

    //update
    @Test
    public void should_return_employee_when_call_service_update_method_given_service(){
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);

        given(employeeRepository.update(1,newEmployee)).willReturn(newEmployee);

        //when
        Employee result = employeeService.update(1,newEmployee);


        //then
        assertThat(result.getSalary(), equalTo(8000));
    }

    //insert
    @Test
    public void should_return_employee_when_call_service_insert_method_given_service(){
        //given
        Employee newEmployee = new Employee(1, "Evan", "F", 22, 8000);

        given(employeeRepository.insert(newEmployee)).willReturn(newEmployee);

        //when
        Employee result = employeeService.insert(newEmployee);


        //then
        assertThat(result.getName(), equalTo("Evan"));
    }

    //delete
    @Test
    public void should_return_nothing_when_call_service_delete_method_given_service(){
        //given

        //when
        employeeService.delete(1);

        //then
        verify(employeeRepository,times(1)).delete(1);
    }



}
