package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @GetMapping(params = {"/gender"})
    public List<Employee> getEmployeeByGender(@RequestParam("gender") String gender) {
        return employeeRepository.findByGender(gender);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.insert(employee);
    }

    @PutMapping("/{employeeId}" )
    public Employee updateEmployee(@PathVariable("employeeId") Integer employeeId,@RequestBody Employee updateEmployee){
        return employeeRepository.update(employeeId,updateEmployee);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("employeeId") Integer employeeId){
         employeeRepository.delete(employeeId);
    }

    @GetMapping(params = {"page","size"})
    public List<Employee> getAllEmployeeByPage(@RequestParam Integer page,@RequestParam Integer size){
        return employeeRepository.findAllEmployeeByPage(page,size);
    }

}
