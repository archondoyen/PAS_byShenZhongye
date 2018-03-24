package com.archon.service.impl;

import com.archon.dao.EmployeeDao;
import com.archon.po.Employee;
import com.archon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean addEmp(Employee employee) {
        return employeeDao.addEmp(employee);
    }

    @Override
    public boolean updateEmp(Employee employee) {
        return employeeDao.updateEmp(employee);
    }

    @Override
    public List<Employee> queryEmp(Employee employee) {
        return employeeDao.queryEmp(employee);
    }
}