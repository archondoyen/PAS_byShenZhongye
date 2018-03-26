package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Employee;
import com.archon.po.Notice;
import com.archon.po.Visitor;
import com.archon.service.NoticeService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "adminGetNoticeNumRecruit.view")
    public Integer adminGetRecruitNum(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.RECRUITMENT_NOTICE);
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        return noticeService.queryNotice(notice).size();
    }    @RequestMapping(value = "adminGetNoticeNumInterView.view")
    public Integer adminGetInterViewNum(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.INTERVIEW_NOTICE);
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        return noticeService.queryNotice(notice).size();
    }
    @RequestMapping(value = "visitorViewNoticeNotRead.view")
    public String visitorShowNotice(HttpSession session,Model model){
        Visitor visiotr = (Visitor) session.getAttribute("visitor");
        Notice notice = new Notice();
        notice.setTargetId(visiotr.getId());
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "visitor/visitorNotice/visitorManageNotice";
    }
    /*收到简历后，通知是否面试*/
   @RequestMapping(value = "adminViewNoticeNotRead.Recruitment")
    public String adminShowNoticeRecruitment(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.RECRUITMENT_NOTICE);
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "admin/adminNotice/adminManageNoticeRecruitTowardInterview";
    }
    /*面试信息达到后，通知是否入职*/
    @RequestMapping(value = "adminViewNoticeNotRead.interview")
    public String adminShowNoticeInterview(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.INTERVIEW_NOTICE);
/*
        notice.setIsRead(Notice.NOTICE_NOT_READ);//有些人不去点“我知道了"，所以就不查了
*/
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "admin/adminNotice/adminManageNoticeInterviewTowardEmploy";
    }
    /*财务管理员都可以看本公司的工资提取信息*/
    @RequestMapping(value = "adminViewNoticeNotRead.salay")
    public String adminShowNoticeEmployeeGetSalayOrNot(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        if(Admin.FINAICAL_ADMIN.equals(admin.getAType())){
            return "admin/success";
        }
        Notice notice = new Notice();
        notice.setTargetId(admin.getCompanyId());
        notice.setNoticeType(Notice.SAL_NOTICE);
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "admin/adminNotice/adminManageNoticeRecruitTowardSalay";
    }
    @RequestMapping(value = "DelNotice.do")
    public String delNotice(@RequestParam(value = "noticeId",required = false) String noticeIdStr){
        int noticeId = Integer.parseInt(noticeIdStr);
        Notice notice = new Notice();
        notice.setId(noticeId);
        notice.setIsDeleted(Notice.NOTICE_IS_DELETE);
        boolean b = noticeService.updateNotice(notice);
        String info = "";
        /*提示信息详情*/
            Notice notice1 = noticeService.queryNotice(notice).get(0);
            info+=notice1.toString();
        if(b){
            info +="，删除成功";
        }else{
            info += "，删除失败";
        }
        return info;
    }@RequestMapping(value = "readNotice.oper")
    public String readNotice(@RequestParam(value = "noticeId",required = false) String noticeIdStr){
        int noticeId = Integer.parseInt(noticeIdStr);
        Notice notice = new Notice();
        notice.setId(noticeId);
        notice.setIsDeleted(Notice.NOTICE_IS_READ);
        String info = "";
        /*信息会提示出来*/
            Notice notice1 = noticeService.queryNotice(notice).get(0);
            info+=notice1.toString();
        /*更新信息为已读*/
        boolean b = noticeService.updateNotice(notice);
        if(b){
            info +="，已读";
        }else{
            info += "，未读";
        }
        return info;
    }
    @RequestMapping(value = "adminSendInterview.oper")
    public String adminSendInterview( @RequestParam(value = "noticeContent",required = false) String noticeContent,
                                     @RequestParam(value = "noticeTargetId",required = false)String targetIdStr){
        Notice notice = new Notice();
        /*已经是INTERVIEW_NOTICE，但是重新设置一下，防止误操作*/
        notice.setNoticeType(Notice.INTERVIEW_NOTICE);
        notice.setCreateTime(TimeUtil.getTimeStamp());
        notice.setNoticeContent(noticeContent);
        int targetId = Integer.parseInt(targetIdStr);
        notice.setTargetId(targetId);
        boolean b = noticeService.addNotice(notice);
        String info = null;
        if(b){
            info = "面试通知发送完毕！";
        }else{
            info = "面试通知未发送！";
        }
        return info;
    }
}