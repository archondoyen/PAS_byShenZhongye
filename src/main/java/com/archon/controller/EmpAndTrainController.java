package com.archon.controller;

import com.archon.po.*;
import com.archon.service.EmpAndTrainService;
import com.archon.service.EmployeeService;
import com.archon.service.NoticeService;
import com.archon.service.TrainService;
import com.archon.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value ="empAndTrain")
public class EmpAndTrainController {
        @Autowired
        private EmpAndTrainService empAndTrainService;
        @Autowired
        private NoticeService noticeService;
        @Autowired
        private EmployeeService employeeService;
        @Autowired
        private TrainService trainService;
        @RequestMapping(value = "adminNewTrain.entrance")
        public String adminNewTrainEntrance(){
            return "admin/adminTrain/adminNewTrain";
        }
        @RequestMapping(value = "adminNewTrain.do")
        public String adminNewTrainDo(HttpSession session, Model model, @ModelAttribute Train train,
                                      @RequestParam(value = "empId",required = false)String empIdStr){
            String info = "";
            /*把train插入Train表*/
            train.setTrainResult(Train.TRAIN_RESULT_NULL);
            boolean b1 = trainService.addTrain(train);
            if(b1){
                info+="成功新建培训。";
            }
            if(empIdStr==null){
                model.addAttribute("info",info);
                return "admin/adminTrain/adminNewTrain";
            }
            /*验证empId*/
            int empId = Integer.parseInt(empIdStr);
            Employee employee = new Employee();
            employee.setId(empId);
            List<Employee> employees = employeeService.queryEmp(employee);
            if (employees == null||employees.size()==0) {
                info = "员工不存在！";
                model.addAttribute("info",info);
                return "admin/adminTrain/adminNewTrain";
            }
            Employee emp = employees.get(0);
           /*关联Train和员工Id*/
            EmpAndTrain empAndTrain = new EmpAndTrain();
            empAndTrain.setEmpId(empId);
            empAndTrain.setTrainId(train.getId());
            boolean b2 = empAndTrainService.addET(empAndTrain);
            if(b2){
                info+="培训和该员工成功关联。";
            }else{
                info+="培训和该员工关联失败！";
                model.addAttribute("info",info);
                return "admin/adminTrain/adminNewTrain";
            }
            /*给员工发送培训通知*/
            Integer visitorId = emp.getVisitorId();
            Notice notice = new Notice();
            notice.setTargetId(visitorId);
            Admin admin = (Admin) session.getAttribute("admin");
            notice.setSenderId(admin.getId());
            notice.setNoticeContent(Notice.NEW_TRAIN_NOTICE);
            notice.setCreateTime(TimeUtil.getTimeStamp());
            boolean b = noticeService.addNotice(notice);
            if(b){
                info+="培训消息已发送给该员工。";
            }else {
                info+="消息正发送给员工，但发送失败。";
            }
            model.addAttribute("info",info);
            return "admin/adminTrain/adminNewTrain";
        }
        @RequestMapping(value = "adminSendTrain.entrance")
        public String adminSendTrainEntrance(Model model){
            /*查未评级的trainList*/
            Train train0 = new Train();
            train0.setTrainResult(Train.TRAIN_RESULT_NULL);
            List<Train> trains = trainService.queryTrain(train0);
            /*把trainList和empName一一对应*/
            List<EmpAndTrain> empAndTrains = new ArrayList<>();
            for (Train train : trains) {
                EmpAndTrain empAndTrain = new EmpAndTrain();
                empAndTrain.setTrainId(train.getId());
                List<EmpAndTrain> empAndTrains1 = empAndTrainService.queryET(empAndTrain);
                if (empAndTrains1 != null&& empAndTrains1.size()>0) {
                    for (EmpAndTrain eAndT1 : empAndTrains1) {
                        empAndTrains.add(eAndT1);
                    }
                }
            }
            model.addAttribute("empAndTrainList",empAndTrains);
            return "admin/adminTrain/adminSendTrainResult";
        }
        @RequestMapping(value = "adminSetTrainResult.oper")
        public String adminSetTrainResultOper(
                @RequestParam(value = "trainId",required = false)String trainIdStr,
                @RequestParam(value = "trainResult",required = false)String trainResultUnchecked){
            String info = null;
            if(Train.TRAIN_RESULT_BEST.equals(trainResultUnchecked.trim())
                    ||Train.TRAIN_RESULT_LOW.equals(trainResultUnchecked.trim())
                    ||Train.TRAIN_RESULT_MIDDLE.equals(trainResultUnchecked.trim())){
                int trainId = Integer.parseInt(trainIdStr);
                Train train = new Train();
                train.setId(trainId);
                train.setTrainResult(trainResultUnchecked.trim());
                boolean b = trainService.updateTrain(train);
                if(b){
                    info ="评级成功";
                }else {
                    info="评级失败";
                }
                return info;
            }
            info = "输入了不合法的评级结果";
            return info;
        }
}