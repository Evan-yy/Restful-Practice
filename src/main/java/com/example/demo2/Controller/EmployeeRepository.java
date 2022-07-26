package com.example.demo2.Controller;

import com.example.demo2.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
        employees.add(new Employee(0, "Wang", "M", 20, 1000));
        employees.add(new Employee(1, "Li", "M", 21, 1000));
        employees.add(new Employee(2, "Wu", "L", 22, 1000));
        employees.add(new Employee(3, "Chen", "M", 23, 1000));
    }


    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(int employeeId) {
        return employees
                .stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findByGender(String gender) {
        return employees
                .stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public Employee insert(Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;

    }

    public Employee update(Integer employeeId, Employee updateEmployee) {
        return employees.stream().filter(employee -> employee.getId() == employeeId).findFirst().map(employee -> employee.update(updateEmployee)).orElseThrow(EmployeeNotFoundException::new);
    }

    public void delete(Integer employeeId) {
        employees.removeIf(employee -> employee.getId() == employeeId);
    }

    public List<Employee> findAllEmployeeByPage(Integer page, Integer size) {
        return employees.stream().skip((page - 1) * size).limit(size).collect(Collectors.toList());
    }
}
