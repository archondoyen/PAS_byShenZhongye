package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Notice;
import com.archon.po.RewardPunish;
import com.archon.service.NoticeService;
import com.archon.service.RewardAndPunishService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "rewardAndPunish")
public class RewardAndPunishController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private RewardAndPunishService rewardAndPunishService;
    @RequestMapping(value = "adminNewRewardAndPunish.entrance")
    public String adminNewRewardAndPunishEntrance(){
        return "admin/adminManagerRewardAndPunish/adminNewRewardPunish";
    }
    @RequestMapping(value = "adminNewRewardAndPunish.do")
    public String adminNewRewardAndPunishDo(Model model, @ModelAttribute RewardPunish rewardPunish, HttpSession session){
        String info = "";
        rewardPunish.setRpTime(TimeUtil.getTimeStamp());
        boolean b = rewardAndPunishService.addRP(rewardPunish);
        if(b){
            info += "奖惩已经记录";
        }else{
            info +="奖惩未能正确记录";
        }
        Notice notice = new Notice();
        Admin admin = (Admin) session.getAttribute("admin");
        notice.setSenderId(admin.getId());
        notice.setTargetId(rewardPunish.getEmpId());
        notice.setCreateTime(TimeUtil.getTimeStamp());
        notice.setNoticeType(Notice.REWARD_PUNISH_NOTICE);
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        boolean b1 = noticeService.addNotice(notice);
        if(b1){
            info+=" 消息已发送给员工。";
        }else{
            info+=" 消息发送员工时失败。";
        }
        model.addAttribute("info",info);
        return "admin/adminManageRewardAndPunish/adminNewRewardPunish";
    }
    @RequestMapping(value = "adminShowRewarnAndPunish.view")
    public String adminShowRewarnAndPunish(Model model){
        RewardPunish rewardPunish = new RewardPunish();
        List<RewardPunish> rewardPunishes = rewardAndPunishService.queryRewardPunish(rewardPunish);
        model.addAttribute("rp",rewardPunishes);
        return "admin/adminManageRewardAndPunish/adminManageRewardPunish";
    }
}