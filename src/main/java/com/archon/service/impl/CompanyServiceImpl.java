package com.archon.service.impl;

import com.archon.dao.CompanyDao;
import com.archon.po.Company;
import com.archon.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CompanyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    @Override
    public Company queryCompany(Company company) {
        return companyDao.queryCompany(company);
    }
}