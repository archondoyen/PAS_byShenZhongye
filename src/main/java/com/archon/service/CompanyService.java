package com.archon.service;

import com.archon.po.Company;

public interface CompanyService {
    boolean addCompany(Company company);
    Company updateCompany(Company company);
    Company queryCompany(Company company);
}