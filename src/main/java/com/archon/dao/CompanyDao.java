package com.archon.dao;

import com.archon.po.Company;

public interface CompanyDao {
    boolean addCompany(Company company);
    Company updateCompany(Company company);
    Company queryCompany(Company company);
    Company queryCompanyById(Integer id);
}