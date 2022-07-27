package com.example.demo2.Service;

import com.example.demo2.Entity.Company;
import com.example.demo2.Entity.Employee;
import com.example.demo2.Repoasitory.CompanyRepository;
import com.example.demo2.Repoasitory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findByCompanyId(int companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    public List<Employee> findEmployeesInCompany(int companyId) {
        return companyRepository.findEmployeesInCompany(companyId);
    }

    public List<Company> findAllCompaniesByPage(Integer page, Integer size) {
        return companyRepository.findAllCompaniesByPage(page,size);
    }

    public Company insertCompany(Company company) {
        return companyRepository.insertCompany(company);
    }

    public Company update(Integer companyId, Company company) {
        return companyRepository.update(companyId,company);
    }

    public void delete(Integer companyId) {
        companyRepository.delete(companyId);
    }
}
