package com.archon.controller;

import com.archon.po.Recruitment;
import com.archon.service.DeptAndJobService;
import com.archon.service.RecruitmentService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "recruit")
public class RecruitmentController {
    @Autowired
    private DeptAndJobService deptAndJobService;
    @Autowired
    private RecruitmentService recruitmentService;
    @RequestMapping(value = "adminRecruit.entrance")
    public String adminRecruitEntrance(){return "admin/adminNewRecruitment/adminNewRecruitment";}
   @RequestMapping(value = "adminAddRecruit.do")
    public String adminAddRecruit(HttpSession session, Model model, @RequestParam(value = "jobAndDeptId",required = false) String djId, @ModelAttribute Recruitment recruitment){
       int newId = Integer.parseInt(djId);
       recruitment.setJobAndDeptId(newId);
       boolean b = recruitmentService.newRec(recruitment);
       if(b){
           model.addAttribute("Recruit",recruitment);
       }else{
           model.addAttribute("info","添加失败");
       }
       return "admin/adminNewRecruitment/adminNewRecruitment";
    }
    @RequestMapping(value = "showRec")
    public String visitorViewRec(Model model){
        List<Recruitment> recruitments = recruitmentService.queryRec(new Recruitment());
        model.addAttribute("Recruit",recruitments);
        return "visitor/visitorRecruitment/visitorScanRecruit";
    }
    @RequestMapping(value = "showRec/{recruitmentId}")
    public String visitorViewRecWithRecId(Model model, @PathVariable(value = "recruitmentId") String recuitmentIdl){
        Recruitment recruitment = new Recruitment();
        int recId = Integer.parseInt(recuitmentIdl);
        recruitment.setId(recId);
        List<Recruitment> recruitments = recruitmentService.queryRec(recruitment);
        model.addAttribute("Recruit",recruitments.get(0));
        return "visitor/visitorRecruitment/visitorRecruitDetial";
    }

}