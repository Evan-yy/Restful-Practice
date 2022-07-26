package com.example.demo2.Controller;

import com.example.demo2.Exception.CompanyNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {

    private ArrayList<Company> companies;

    public CompanyRepository() {
        ArrayList<Employee> springEmployees = new ArrayList<>();
        springEmployees.add(new Employee(0, "Wang", "M", 20, 1000));
        springEmployees.add(new Employee(1, "Chen", "M", 22, 1400));
        springEmployees.add(new Employee(2, "Wu", "F", 24, 1200));

        ArrayList<Employee> sunEmployees = new ArrayList<>();
        sunEmployees.add(new Employee(0, "Huang", "M", 25, 1000));
        sunEmployees.add(new Employee(1, "Xu", "M", 26, 1400));
        sunEmployees.add(new Employee(2, "Li", "F", 23, 1200));

        companies = new ArrayList<>();
        companies.add(new Company(0, "spring", springEmployees));
        companies.add(new Company(1, "sun", sunEmployees));
    }

    public List<Company> findAll() {
        return companies;
    }

    public Company findByCompanyId(int companyId) {
        return companies
                .stream()
                .filter(company -> company.getId() == companyId)
                .findFirst()
                .orElseThrow(CompanyNotFoundException::new);
    }

    public List<Employee> findEmployeesInCompany(int companyId) {
        return companies
                .stream()
                .filter(company -> company.getId() == companyId)
                .findFirst()
                .orElseThrow(CompanyNotFoundException::new)
                .getEmployees();
    }

    public List<Company> findAllCompaniesByPage(Integer page, Integer size) {
        return companies
                .stream()
                .skip((page-1)*size)
                .limit(size)
                .collect(Collectors.toList());
    }

    public Company insertCompany(Company company) {
        company.setId(companies.size());
        companies.add(company);
        return company;
    }

    public Company update(Integer companyId, Company company) {
        return companies
                .stream()
                .filter(c->c.getId()==companyId)
                .findFirst().map(c->c.update(company))
                .orElseThrow(CompanyNotFoundException::new);
    }
}
