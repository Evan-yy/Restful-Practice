package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyRepository.findByCompanyId(companyId);
    }


}
