package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    @GetMapping("/{companyId}/employees")
    public List<Employee> getAllEmployeesInCompany(@PathVariable int companyId) {
        return companyRepository.findEmployeesInCompany(companyId);
    }

    @GetMapping(params = {"page", "size"})
    public List<Company> getAllCompaniesByPage(@RequestParam Integer page,@RequestParam Integer size){
        return companyRepository.findAllCompaniesByPage(page,size);
    }

}
