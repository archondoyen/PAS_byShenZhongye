package com.archon.service.impl;

import com.archon.dao.DeptAndJobDao;
import com.archon.po.DeptAndJob;
import com.archon.service.DeptAndJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "DeptAndJobService")
public class DeptAndJobServiceImpl implements DeptAndJobService {
    @Autowired
    private DeptAndJobDao deptAndJobDao;
    @Override
    public boolean adminNewDeptAndJob(DeptAndJob deptAndJob) {
        return deptAndJobDao.addDeptAndJob(deptAndJobDao);
    }

    @Override
    public DeptAndJob adminManagerDeptAndJob(DeptAndJob deptAndJob) {
        return deptAndJobDao.updateDeptAndJob(deptAndJob);
    }

    @Override
    public List<DeptAndJob> queryDeptAndJob(DeptAndJob deptAndJob) {
        return deptAndJobDao.queryDeptAndJob(deptAndJob);
    }
}