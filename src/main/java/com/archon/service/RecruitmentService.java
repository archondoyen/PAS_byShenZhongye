package com.archon.service;

import com.archon.po.Recruitment;
import java.util.List;

public interface RecruitmentService {
    boolean newRec(Recruitment recruitment);
    Recruitment manageRec(Recruitment recruitment);
    List<Recruitment> queryRec(Recruitment recruitment);
    boolean deletRec(Recruitment recruitment);
}