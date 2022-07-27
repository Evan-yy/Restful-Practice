package com.example.demo2.Controller;

import com.example.demo2.Entity.Employee;
import com.example.demo2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping(params = {"gender"})
    public List<Employee> getEmployeeByGender(@RequestParam String gender) {
        return employeeService.findByGender(gender);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee updateEmployee) {
        return employeeService.update(employeeId, updateEmployee);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.delete(employeeId);
    }

    @GetMapping(params = {"page", "size"})
    public List<Employee> getAllEmployeeByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return employeeService.findAllEmployeeByPage(page, size);
    }

}
