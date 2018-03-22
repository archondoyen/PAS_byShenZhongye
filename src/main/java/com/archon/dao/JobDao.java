package com.archon.dao;

import com.archon.po.Job;

import java.util.List;

public interface JobDao {
    boolean addJob(Job job);
    Job updateJob(Job job);
    List<Job> queryJob(Job job);
}