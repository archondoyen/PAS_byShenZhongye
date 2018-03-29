package com.archon.dao;

import com.archon.po.EducationExp;

public interface EduExpDao {
    boolean addEdu(EducationExp exp);
    boolean updateEdu(EducationExp exp);
    EducationExp queryEdu(EducationExp exp);
    boolean deleteEdu(EducationExp exp);
}