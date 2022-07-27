package com.example.demo2.Controller;

import com.example.demo2.Entity.Company;
import com.example.demo2.Entity.Employee;
import com.example.demo2.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyService.findByCompanyId(companyId);
    }

    @GetMapping("/{companyId}/employees")
    public List<Employee> getAllEmployeesInCompany(@PathVariable int companyId) {
        return companyService.findEmployeesInCompany(companyId);
    }

    @GetMapping(params = {"page", "size"})
    public List<Company> getAllCompaniesByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return companyService.findAllCompaniesByPage(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody Company company) {
        return companyService.insertCompany(company);
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@PathVariable Integer companyId, @RequestBody Company company) {
        return companyService.update(companyId, company);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCompanyById(@PathVariable("companyId") Integer companyId) {
        companyService.delete(companyId);
    }

}
