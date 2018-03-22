package com.archon.service.impl;

import com.archon.dao.RecruitmentDao;
import com.archon.po.Recruitment;
import com.archon.service.RecruitmentService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "RecruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Override
    public boolean newRec(Recruitment recruitment) {
        recruitment.setRecruitmentCreateTime(TimeUtil.getTimeStamp());
        return recruitmentDao.addRec(recruitment);
    }

    @Override
    public Recruitment manageRec(Recruitment recruitment) {
        return recruitmentDao.updateRec(recruitment);
    }

    @Override
    public List<Recruitment> queryRec(Recruitment recruitment) {
        return recruitmentDao.queryRec(recruitment);
    }

    @Override
    public boolean deletRec(Recruitment recruitment) {
        return recruitmentDao.deletRec(recruitment);
    }
}