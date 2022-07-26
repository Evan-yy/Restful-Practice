package com.example.demo2.Controller;

import com.example.demo2.Exception.CompanyNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
