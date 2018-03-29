package com.archon.controller;

import com.archon.po.Skill;
import com.archon.po.Visitor;
import com.archon.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @RequestMapping(value = "visiotrAddSkill.entrance")
    public String visiotrAddSkillEntrance(){return "visitor/visitorSkill/visitorAddSkillMsg";}
    @RequestMapping(value = "visiotrAddSkill.do")
    public String visiotrAddSkillDo(HttpSession session, Model model, @ModelAttribute Skill skill){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        skill.setVisitorId(visitor.getId());
        boolean b = skillService.addSkill(skill);
        if(b){
            model.addAttribute("info","add skill OK!");
        }else{
            model.addAttribute("info","Fail!");
        }
        return "visitor/visitorSkill/visitorAddSkillMsg";
    }

}