package com.archon.service.impl;

import com.archon.dao.JobTypeDao;
import com.archon.po.Jobtype;
import com.archon.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "jobTypeService")
public class JobTypeServiceImpl implements JobTypeService {
    @Autowired
    private JobTypeDao jobTypeDao;
    @Override
    public boolean addJobType(Jobtype jobtype) {
        return false;
    }

    @Override
    public Jobtype updateJobType(Jobtype jobtype) {
        return null;
    }

    @Override
    public List<Jobtype> queryJobType(Jobtype jobtype) {
        return null;
    }
}