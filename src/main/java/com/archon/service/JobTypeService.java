package com.archon.service;

import com.archon.po.Jobtype;

import java.util.List;

public interface JobTypeService {
    boolean addJobType(Jobtype jobtype);
    Jobtype updateJobType(Jobtype jobtype);
    List<Jobtype> queryJobType(Jobtype jobtype);
}