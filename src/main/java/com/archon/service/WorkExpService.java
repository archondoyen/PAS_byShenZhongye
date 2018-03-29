package com.archon.service;

import com.archon.po.WorkExp;

public interface WorkExpService {
    boolean addworkExp(WorkExp exp);
    boolean updateworkExp(WorkExp exp);
    WorkExp queryworkExp(WorkExp exp);
    boolean deleteworkExp(WorkExp exp);
}