package com.archon.dao;

import com.archon.po.Skill;

public interface SkillDao {
    boolean addSkill(Skill skill);
    Skill updateSkill(Skill skill);
    Skill querySkill(Skill skill);
}