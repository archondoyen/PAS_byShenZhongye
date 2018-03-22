package com.archon.service;

import com.archon.po.Department;

import java.util.List;

public interface DeptService {
    boolean newDept(Department department);
    Department manageDept(Department department);
    List<Department> queryDept(Department department);
    boolean deletDept(Department department);
}