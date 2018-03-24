package com.archon.service.impl;

import com.archon.dao.SkillDao;
import com.archon.po.Skill;
import com.archon.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "SkillService")
public class SkillServiceImp implements SkillService {
    @Autowired
    private SkillDao skillDao;
    @Override
    public boolean addSkill(Skill skill) {
        return skillDao.addSkill(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillDao.updateSkill(skill);
    }

    @Override
    public Skill querySkill(Skill skill) {
        return skillDao.querySkill(skill);
    }
}