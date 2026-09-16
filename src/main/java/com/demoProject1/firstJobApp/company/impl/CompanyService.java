package com.demoProject1.firstJobApp.company.impl;

import com.demoProject1.firstJobApp.company.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);
    void createCompany(Company company);
}
