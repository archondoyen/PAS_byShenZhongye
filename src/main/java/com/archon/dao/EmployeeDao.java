package com.archon.dao;

import com.archon.po.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean addEmp(Employee employee);
    boolean updateEmp(Employee employee);
    List<Employee> queryEmp(Employee employee);
}