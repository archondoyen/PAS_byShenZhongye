package com.archon.dao;

import com.archon.po.Recruitment;

import java.util.List;

public interface RecruitmentDao {
    boolean addRec(Recruitment recruitment);
    Recruitment updateRec(Recruitment recruitment);
    List<Recruitment> queryRec(Recruitment recruitment);
    boolean deletRec(Recruitment recruitment);
}