package com.archon.service;

import com.archon.po.Employee;

import java.util.List;

public interface EmployeeService {
    boolean addEmp(Employee employee);
    boolean updateEmp(Employee employee);
    List<Employee> queryEmp(Employee employee);
}