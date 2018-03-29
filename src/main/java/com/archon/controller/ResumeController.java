package com.archon.controller;

import com.archon.po.Notice;
import com.archon.po.Recruitment;
import com.archon.po.Resume;
import com.archon.po.Visitor;
import com.archon.service.NoticeService;
import com.archon.service.RecruitmentService;
import com.archon.service.ResumeService;
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
@RequestMapping(value = "resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private RecruitmentService recruitmentService;
    @RequestMapping(value = "visitorNewResume.entrance/{recId}/{createrId}")
    public String visitorNewResumeForRecruitmentEntrance(HttpSession session,Model model, @PathVariable(value = "recId") String recId, @PathVariable(value = "createrId") String createrId){
        int recIdInt = Integer.parseInt(recId);
        int createrIdInt = Integer.parseInt(createrId);
        model.addAttribute("recId",recIdInt);
        model.addAttribute("createrId",createrIdInt);
        Recruitment recruitment = new Recruitment();
        recruitment.setId(recIdInt);
        List<Recruitment> recruitments = recruitmentService.queryRec(recruitment);
        model.addAttribute("recruitment",recruitments.get(0));
        Visitor  visitor = (Visitor) session.getAttribute("visitor");
        model.addAttribute("visitor",visitor);
        return "visitor/visitorResume/visitorNewResume";
    }
    @RequestMapping(value = "visitorNewResume.do")
    public String visitorNewResumeForRecruitmentDo(@RequestParam(value = "noticeContent",required = false) String noticeContent,@ModelAttribute Resume resume, HttpSession session, Model model, @RequestParam(value = "createrId")Integer createrId){
        String info = " ";
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        int vId = visitor.getId();
        resume.setVisiorId(vId);
        boolean a = resumeService.addResume(resume);
        if(!a){
            info="简历创建失败！";/*所以没有给管理员任何消息*/
            model.addAttribute("info",info);
            return "visitor/success";
        }
        /*消息*/
        Notice notice = new Notice();
        notice.setSenderId(vId);
        notice.setTargetId(createrId);
        /*Recruitment表中拼接“职位、部门、公司”作为notice的content*/
        notice.setNoticeContent(noticeContent);
        notice.setNoticeType(Notice.RECRUITMENT_NOTICE);
        notice.setCreateTime(TimeUtil.getTimeStamp());
        boolean b = noticeService.addNotice(notice);
        /*反馈给发送的访客*/
        if (!b){
            info="消息发送失败！HR无法收到您的求职信息";
            model.addAttribute("info",info);
            return "visitor/success";
        }
        model.addAttribute("resume",resume);
        model.addAttribute("notice",notice);
        return "visitor/success";
    }
}