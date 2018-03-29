package com.archon.dao;

import com.archon.po.WorkExp;

public interface WorkExpDao {
    boolean addworkExp(WorkExp exp);
    boolean updateworkExp(WorkExp exp);
    WorkExp queryworkExp(WorkExp exp);
    boolean deleteworkExp(WorkExp exp);
}