package com.archon.service.impl;

import com.archon.dao.JobDao;
import com.archon.po.Job;
import com.archon.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "JobService")
public class JobServiceImpl implements JobService {
   @Autowired
   private JobDao jobDao;
    @Override
    public boolean addJob(Job job) {
        return false;
    }

    @Override
    public Job updateJob(Job job) {
        return null;
    }

    @Override
    public List<Job> queryJob(Job job) {
        return null;
    }
}