package com.archon.controller;

import com.archon.po.Employee;
import com.archon.po.Notice;
import com.archon.service.EmployeeService;
import com.archon.service.NoticeService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "emp")
public class EmployeeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "empReturnEntrance.do")
    public String empReturnEntrance(){
        return "employee/success";
    }
    @RequestMapping(value = "changeVisitorToEmployeeByInterviewNotice.do")
    public String adminNewEmpByInterviewNotice(
            @RequestParam(value = "noticeId",required = false)String noticeIdStr,
            @RequestParam(value = "noticeContent",required = false)String noticeContent,
            @RequestParam(value = "targetId",required = false)String targetIdStr,
            @RequestParam(value = "sal",required = false)String salStr,
            @RequestParam(value = "deptAndJobId",required = false)String deptAndJobIdStr){
        String info = null;
        /*修改消息类型为入职消息*/
        int noticeId = Integer.parseInt(noticeIdStr);
        Notice notice = new Notice();
        notice.setId(noticeId);
        notice.setNoticeType(Notice.NEW_EMPLOYEE_NOTICE);
        boolean b = noticeService.updateNotice(notice);
        if(b){
            info="该用户已经被修改为：正式员工。";
        }else {
            info = "该用户入职消息记录，没有正确的修改。";
        }
        Employee employee = new Employee();
        int targetId = Integer.parseInt(targetIdStr);
        employee.setVisitorId(targetId);
        employee.setHiredate(TimeUtil.getTimeStamp());
        double sal = Double.parseDouble(salStr);
        employee.setSal(new BigDecimal(sal));
        int deptAndJobId = Integer.parseInt(deptAndJobIdStr);
        employee.setDeptandjobId(deptAndJobId);
        boolean b1 = employeeService.addEmp(employee);
        if (b1){
            info+="而且，用户成功转换成员工！";
        }else{
            info+="而且，用户没有正确的转换为员工，可能是工资或工作信息输入格式有误";
        }
        return info;
    }
}