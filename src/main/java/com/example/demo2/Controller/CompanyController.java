package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping
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
    public List<Company> getAllCompaniesByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return companyRepository.findAllCompaniesByPage(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.insertCompany(company);
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@PathVariable Integer companyId, @RequestBody Company company) {
        return companyRepository.update(companyId, company);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCompanyById(@PathVariable("companyId") Integer companyId) {
        companyRepository.delete(companyId);
    }

}
