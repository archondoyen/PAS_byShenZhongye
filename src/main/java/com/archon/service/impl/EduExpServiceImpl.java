package com.archon.service.impl;

import com.archon.dao.EduExpDao;
import com.archon.po.EducationExp;
import com.archon.service.EduExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "EduExpService")
public class EduExpServiceImpl implements EduExpService{
@Autowired
private EduExpDao eduExpDao;
    @Override
    public boolean addEdu(EducationExp exp) {
        return eduExpDao.addEdu(exp);
    }

    @Override
    public boolean updateEdu(EducationExp exp) {
        return eduExpDao.updateEdu(exp);
    }

    @Override
    public EducationExp queryEdu(EducationExp exp) {
        return eduExpDao.queryEdu(exp);
    }

    @Override
    public boolean deleteEdu(EducationExp exp) {
        return eduExpDao.deleteEdu(exp);
    }
}