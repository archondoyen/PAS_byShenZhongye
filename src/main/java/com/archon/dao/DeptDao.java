package com.archon.dao;

import com.archon.po.Department;

import java.util.List;

public interface DeptDao {
    boolean addDept(Department department);
    Department updateDept(Department department);
    List<Department> queryDept(Department department);
    boolean deletDept(Department department);
}