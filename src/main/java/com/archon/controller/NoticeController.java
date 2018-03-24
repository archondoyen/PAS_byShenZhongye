package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Notice;
import com.archon.po.Visitor;
import com.archon.service.NoticeService;
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
        int noticeNum = noticeService.queryNotice(notice).size();
        return noticeNum;
    }    @RequestMapping(value = "adminGetNoticeNumInterView.view")
    public Integer adminGetInterViewNum(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.INTERVIEW_NOTICE);
        int noticeNum = noticeService.queryNotice(notice).size();
        return noticeNum;
    }
    @RequestMapping(value = "visitorViewNoticeNotRead.view")
    public String visitorShowNotice(HttpSession session,Model model){
        Visitor visiotr = (Visitor) session.getAttribute("visitor");
        Notice notice = new Notice();
        notice.setTargetId(visiotr.getId());
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "visitor/visitorNotice/visitorManageNotice";
    }
   @RequestMapping(value = "adminViewNoticeNotRead.Recruitment")
    public String adminShowNoticeRecruitment(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.RECRUITMENT_NOTICE);
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "admin/adminNotice/adminManageNotice";
    }@RequestMapping(value = "adminViewNoticeNotRead.interview")
    public String adminShowNoticeInterview(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Notice notice = new Notice();
        notice.setTargetId(admin.getId());
        notice.setNoticeType(Notice.INTERVIEW_NOTICE);
        List<Notice> notices = noticeService.queryNotice(notice);
        model.addAttribute("noticeList",notices);
        return "admin/adminNotice/adminManageNotice";
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
}