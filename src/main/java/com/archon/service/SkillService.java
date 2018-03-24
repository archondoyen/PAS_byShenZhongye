package com.archon.service;

import com.archon.po.Skill;

public interface SkillService {
    boolean addSkill(Skill skill);
    Skill updateSkill(Skill skill);
    Skill querySkill(Skill skill);
}