package com.archon.service;

import com.archon.po.EducationExp;

public interface EduExpService {
    boolean addEdu(EducationExp exp);
    boolean updateEdu(EducationExp exp);
    EducationExp queryEdu(EducationExp exp);
    boolean deleteEdu(EducationExp exp);
}