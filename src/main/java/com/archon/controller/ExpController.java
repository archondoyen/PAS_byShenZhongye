package com.archon.controller;

import com.archon.po.EducationExp;
import com.archon.po.Visitor;
import com.archon.po.WorkExp;
import com.archon.service.EduExpService;
import com.archon.service.WorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(value = "exp")
public class ExpController {
    @Autowired
   private  WorkExpService workExpService;
    @Autowired
    private EduExpService eduExpService;
    @RequestMapping(value = "visitorAddWorkExp.entrance")
    public String visitorAddWorkExpEntrance(){return "visitor/visitorExp/visitorAddWorkExpMsg";}
    @RequestMapping(value = "visitorAddWorkExp.do")
    public String visitorAddWorkExpDo(HttpSession session, @ModelAttribute WorkExp exp, Model model,
                                      @RequestParam(value = "startDate1",required = false) String startDateStr,
                                      @RequestParam(value = "endDate1",required = false) String endDateStr){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Timestamp startTime = Timestamp.valueOf(startDateStr + " 00:00:00");
        Timestamp endTime = Timestamp.valueOf(endDateStr + " 00:00:00");
        exp.setVisitorId(visitor.getId());
        exp.setStartDate(startTime);
        exp.setEndDate(endTime);
        boolean b = workExpService.addworkExp(exp);
        if(b){
            model.addAttribute("info","OK");
        }else{
            model.addAttribute("info","Failed");
        }
        return "visitor/visitorExp/visitorAddWorkExpMsg";
    }
    @RequestMapping(value = "visitorAddEduExp.entrance")
    public String visitorAddEduExpEntrance(){return "visitor/visitorExp/visitorAddEduExpMsg";}
    @RequestMapping(value = "visitorAddEduExp.do")
    public String visitorAddEduExpDo(HttpSession session, Model model,
                                     @RequestParam(value = "startdate",required = false) String startDateStr,
                                     @RequestParam(value = "enddate",required = false) String endDateStr,
                                     @RequestParam(value = "school",required = false) String schoolStr,
                                     @RequestParam(value = "positionRewarding",required = false) String positionRewarding){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Timestamp startTime = Timestamp.valueOf(startDateStr + " 00:00:00");
        Timestamp endTime = Timestamp.valueOf(endDateStr + " 00:00:00");
        EducationExp exp = new EducationExp();
        exp.setVisitorId(visitor.getId());
        exp.setStartdate(startTime);
        exp.setEnddate(endTime);
        exp.setPositionRewarding(positionRewarding);
        exp.setSchool(schoolStr);
        boolean b = eduExpService.addEdu(exp);
        if(b){
            model.addAttribute("info","OK");
        }else{
            model.addAttribute("info","Failed");
        }
        return "visitor/visitorExp/visitorAddEduExpMsg";
    }
}