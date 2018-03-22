package com.archon.dao;

import com.archon.po.DeptAndJob;

import java.util.List;

public interface DeptAndJobDao {
    boolean addDeptAndJob(DeptAndJobDao deptAndJobDao);
    DeptAndJob updateDeptAndJob(DeptAndJob deptAndJob);
    List<DeptAndJob> queryDeptAndJob(DeptAndJob deptAndJob);
}