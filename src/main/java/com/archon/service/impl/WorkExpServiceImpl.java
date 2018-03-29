package com.archon.service.impl;

import com.archon.dao.WorkExpDao;
import com.archon.po.WorkExp;
import com.archon.service.WorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "WorkExpService")
public class WorkExpServiceImpl implements WorkExpService{
    @Autowired
    private WorkExpDao workExpDao;

    @Override
    public boolean addworkExp(WorkExp exp) {
        return workExpDao.addworkExp(exp);
    }

    @Override
    public boolean updateworkExp(WorkExp exp) {
        return workExpDao.updateworkExp(exp);
    }

    @Override
    public WorkExp queryworkExp(WorkExp exp) {
        return workExpDao.queryworkExp(exp);
    }

    @Override
    public boolean deleteworkExp(WorkExp exp) {
        return workExpDao.deleteworkExp(exp);
    }
}