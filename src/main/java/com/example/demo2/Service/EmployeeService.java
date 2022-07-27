package com.example.demo2.Service;

import com.example.demo2.Entity.Employee;
import com.example.demo2.Repoasitory.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> findByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public Employee update(Integer employeeId, Employee updateEmployee) {
        return employeeRepository.update(employeeId,updateEmployee);
    }

    public Employee insert(Employee employee) {
        return employeeRepository.insert(employee);
    }

    public void delete(Integer employeeId) {
        employeeRepository.delete(employeeId);
    }

    public List<Employee> findAllEmployeeByPage(Integer page, Integer size) {
        return employeeRepository.findAllEmployeeByPage(page,size);
    }

    public void clear(){
        employeeRepository.clear();
    }
}
