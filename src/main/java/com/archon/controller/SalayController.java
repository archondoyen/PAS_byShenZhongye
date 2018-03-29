package com.archon.controller;

import com.archon.po.*;
import com.archon.service.EmployeeService;
import com.archon.service.NoticeService;
import com.archon.service.RewardAndPunishService;
import com.archon.service.SalayService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping(value = "salay")
public class SalayController {
    @Autowired
    private SalayService salayService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RewardAndPunishService rewardAndPunishService;
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "adminPaySalay.entrance")
    public String adminPaySalayEntrance(HttpSession session,Model model){
        /*只有财务管理员才有权限进入*/
        Admin admin = (Admin) session.getAttribute("admin");
        if(Admin.FINAICAL_ADMIN.equals(admin.getAType())){
            return "admin/success";
        }
        Double ratio = Salay.AVG_RATIO;
        model.addAttribute("ratio",ratio);
        return "admin/adminManagerSalay/adminNewSalay";
    }
    @RequestMapping(value = "getEmpNameAndBaseSal.oper")
    public String getEmpNameAndBaseSalOper(@RequestParam(value = "empId",required = false)String empIdStr){
        int empIdUnchecked = Integer.parseInt(empIdStr);
        Employee empUnchecked= new Employee();
        empUnchecked.setId(empIdUnchecked);
        List<Employee> employees = employeeService.queryEmp(empUnchecked);
        if (employees == null||employees.size()==0) {
            return "员工不存在";
        }
        BigDecimal sal = employees.get(0).getSal();
        return sal.toString();
    }@RequestMapping(value = "getRewardAndPunishDetail.oper")
    public String getRewardAndPunishDetailOper(@RequestParam(value = "rpIdStr",required = false)String rpIdStr){
        int rpIdUnchecked = Integer.parseInt(rpIdStr);
        RewardPunish rewardPunish = new RewardPunish();
        rewardPunish.setId(rpIdUnchecked);
        List<RewardPunish> rewardPunishes = rewardAndPunishService.queryRewardPunish(rewardPunish);
        if (rewardPunishes == null||rewardPunishes.size()==0) {
            return "奖惩信息不存在";
        }
        BigDecimal money = rewardPunishes.get(0).getMoney();
        return money.toString();
    }
    @RequestMapping(value = "adminPaySalay.do")
    public String adminPaySalayDo(HttpSession session,@ModelAttribute Salay salay, Model model, @RequestParam(value="base",required = false)String baseSalStr){
        salay.setRatio(new BigDecimal(Salay.AVG_RATIO));
        double baseSal = Double.parseDouble(baseSalStr);
        Admin admin = (Admin) session.getAttribute("admin");
        salay.setCompanyId(admin.getCompanyId());
        salay.setBase(new BigDecimal(baseSal));
        String info = "";
        boolean b = salayService.addSalay(salay);
        if(b){
            info+="工资单创建成功 ";
        }else{
            info+="工资单创建失败 ";
        }
        /*发消息*/
        Notice notice = new Notice();
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        notice.setNoticeType(Notice.SAL_NOTICE);
        notice.setCreateTime(TimeUtil.getTimeStamp());
        notice.setSenderId(admin.getId());
        notice.setTargetId(salay.getEmpId());
        notice.setNoticeContent(salay.getEmployee().getEmpName()+"基本工资："+salay.getBase()+"工作表现"+salay.getWorkerPerformance()+"奖金/罚金"+salay.getRewardPunishList());
        boolean b1 = noticeService.addNotice(notice);
        if (b1){
            info+="消息发送成功 ";
        }else{
            info+="消息发送失败 ";
        }
        model.addAttribute("info",info);
        return "admin/adminManagerSalay/adminNewSalay";
    }
    @RequestMapping(value = "adminShowSal.view")
    public String adminShowSal(Model model,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Salay salay = new Salay();
        salay.setCompanyId(admin.getCompanyId());
        List<Salay> salays = salayService.querySalay(salay);
        model.addAttribute("salayList",salays);
        return "admin/adminManagerSalay/adminManageSalay";
    }
    @RequestMapping(value = "employeeGetSalay.entrance")
    public String employeeGetSalayEntrance(Model model,HttpSession session){
        Employee employyee = (Employee) session.getAttribute("employee");
        Salay salay = new Salay();
        salay.setEmpId(employyee.getId());
        List<Salay> salayNotGet = salayService.findSalayNotGet(salay);
        model.addAttribute("salayList",salayNotGet);
        return "employee/employeeManageSalay/employeeGetSalay";
    }
    @RequestMapping(value = "empGetSalay.oper")
    public @ResponseBody String employeeGetSalayOper(HttpSession session, @RequestParam(value = "salayIdStr",required = false) String  salayIdStr){
        Employee employyee = (Employee) session.getAttribute("employee");
        Salay salay = new Salay();
        int salayId = Integer.parseInt(salayIdStr);
        salay.setEmpId(employyee.getId());
        salay.setId(salayId);
        String info = "";
        List<Salay> salays = salayService.querySalay(salay);
        if (salays == null||salays.size()==0) {
            info+="工资单未找到 ";
            return info;
        }
        salay = salays.get(0);
        salay.setGetSalDate(TimeUtil.getTimeStamp());
        boolean b = salayService.updateSalay(salay);
        if(b){
            info+="工资单已经领取OK";
        }else{
            info+="工资单领取失败Fail";
            /*这里的话，机器就不能开工资了*/
            return info;
        }
        /*发送信息*/
        Notice notice = new Notice();
        notice.setTargetId(employyee.getDeptAndJob().getCompany().getId());
        notice.setSenderId(employyee.getId());
        notice.setNoticeContent("工资总额："+salayService.SumSalay(salay).toString());
        notice.setIsRead(Notice.NOTICE_NOT_READ);
        notice.setCreateTime(TimeUtil.getTimeStamp());
        notice.setNoticeType(Notice.SAL_NOTICE);
        boolean b1 = noticeService.addNotice(notice);
        if(b1){
        }else{
            info+="财务未正确的收到信息，请联络财务管理员MsgNotSend";
        }
        return info;
    }

}