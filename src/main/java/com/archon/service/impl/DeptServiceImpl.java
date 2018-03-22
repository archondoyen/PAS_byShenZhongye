package com.archon.service.impl;

import com.archon.dao.DeptDao;
import com.archon.po.Department;
import com.archon.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "DeptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean newDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public Department manageDept(Department department) {
        return deptDao.updateDept(department);
    }

    @Override
    public List<Department> queryDept(Department department) {
        return deptDao.queryDept(department);
    }

    @Override
    public boolean deletDept(Department department) {
        /*员工为零才可以删除*/
        boolean b = deptDao.deletDept(department);
        return b;
    }
}