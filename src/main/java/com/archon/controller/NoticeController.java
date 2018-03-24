package com.archon.controller;

import com.archon.po.Admin;
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
    @RequestMapping(value = "DelNotice.do")
    public String delNotice(@RequestParam(value = "noticeId",required = false) String noticeIdStr){
        int noticeId = Integer.parseInt(noticeIdStr);
        Notice notice = new Notice();
        notice.setId(noticeId);
        notice.setIsDeleted(Notice.NOTICE_IS_DELETE);
        boolean b = noticeService.updateNotice(notice);
        String info = null;
        if(b){
            info ="删除成功";
        }else{
            info = "删除失败";
        }
        return info;
    }@RequestMapping(value = "readNotice.do")
    public String readNotice(@RequestParam(value = "noticeId",required = false) String noticeIdStr){
        int noticeId = Integer.parseInt(noticeIdStr);
        Notice notice = new Notice();
        notice.setId(noticeId);
        notice.setIsDeleted(Notice.NOTICE_IS_READ);
        boolean b = noticeService.updateNotice(notice);
        String info = null;
        if(b){
            info ="删除成功";
        }else{
            info = "删除失败";
        }
        return info;
    }
    @RequestMapping(value = "adminSendInterview.do")
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