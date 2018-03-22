package com.archon.service;

import com.archon.po.DeptAndJob;

import java.util.List;

public interface DeptAndJobService {
    boolean adminNewDeptAndJob(DeptAndJob deptAndJob);
    DeptAndJob adminManagerDeptAndJob(DeptAndJob deptAndJob);
    List<DeptAndJob> queryDeptAndJob(DeptAndJob deptAndJob);
}