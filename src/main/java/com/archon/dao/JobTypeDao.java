package com.archon.dao;

import com.archon.po.Jobtype;

import java.util.List;

public interface JobTypeDao {
    boolean addJobType(Jobtype jobtype);
    Jobtype updateJobType(Jobtype jobtype);
    List<Jobtype> queryJobType(Jobtype jobtype);
}