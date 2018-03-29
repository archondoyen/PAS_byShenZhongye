package com.archon.controller;

import com.archon.po.Attendance;
import com.archon.po.Employee;
import com.archon.service.AttendanceService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @RequestMapping(value = "empAttendance.entrance")
    public String empAttendanceEntrance(HttpSession session, Model model){
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance attendance = new Attendance();
        attendance.setEmpId(employee.getId());
        List<Attendance> attendances = attendanceService.queryAttendance(attendance);
        if (attendances==null||attendances.size()==0){
            model.addAttribute("info","考勤记录为空");
        }
        model.addAttribute("attendances",attendances);
        return "employee/employeeAttendance/employeeManageAttendance";
    }
    /**
     * 签到,不含迟到打卡，机器触发器打卡，打卡后的迟到、缺勤考核
     */
    @RequestMapping(value = "empSignIn.oper")
    public @ResponseBody String empSignIn(HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance attendance = new Attendance();
        attendance.setEmpId(employee.getId());
        attendance.setStartTime(TimeUtil.getTimeStamp());
        boolean b = attendanceService.addAttendance(attendance);
        String info = null;
        if(b){
            session.setAttribute("signId",attendance.getId());
            info = "签到成功，签到时间"+attendance.getStartTime().toString();
        }else {
            info = "签到失败";
        }
        return info;
    }    /**
     * 签退,不含迟到打卡，机器触发器打卡，打卡后的迟到、缺勤考核
     */
    @RequestMapping(value = "empSignOut.oper")
    public @ResponseBody String empSignOut(HttpSession session){
        boolean result = false;
        String info = null;
        Employee employee = (Employee) session.getAttribute("employee");
        Attendance attendance = new Attendance();
        attendance.setEmpId(employee.getId());
        Object signId = session.getAttribute("signId");
        if (signId != null) {
            Integer attendanceId = (Integer) signId;
            attendance.setId(attendanceId);
            attendance = attendanceService.queryAttendance(attendance).get(0);
            attendance.setEndTime(TimeUtil.getTimeStamp());
            result = attendanceService.updateAttendance(attendance);
        }
        if (signId==null){
            attendance.setEndTime(TimeUtil.getTimeStamp());
            result = attendanceService.addAttendance(attendance);
        }
        if(result){
            info = "签退成功，签退时间"+attendance.getStartTime().toString();
        }else {
            info = "签退失败";
        }
        return info;
    }

}