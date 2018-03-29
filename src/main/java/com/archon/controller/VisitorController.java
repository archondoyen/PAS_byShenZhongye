package com.archon.controller;

import com.archon.po.Employee;
import com.archon.po.Recruitment;
import com.archon.po.Visitor;
import com.archon.service.EmployeeService;
import com.archon.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "visitorMain.entrance")
    public String visitorMainEntrance(){return "visitor/success";}
    @RequestMapping(value = "visitorTop.entrance")
    public String visitorTopEntrance(){
        return "visitor/visitorTop";
    }
    @RequestMapping(value = "visitorReg.entrance")
    public String visitorRegEntrance(){
        return "visitor/visitorRegister";
    }
    @RequestMapping(value = "visitorReg.do")
    public String visitorReg(@ModelAttribute Visitor visitor, HttpSession session, Model model){
        Object b = visitorService.visitorRegister(visitor);
        if(b instanceof Visitor){
            visitor = (Visitor)b;
            session.setAttribute("visitor",visitor);
            model.addAttribute("visitor",visitor);
            return "visitor/success";
        }else{
            model.addAttribute("info","Register Failed!");
            return "index";
        }
    }
    /*保存用户图片*/
    private  String saveImage(MultipartFile file)  {
        /*保存文件路径根目录*/
        String uploadPath = /*context.getRealPath("") + File.separator + */"images" + File.separator;
        /*文件名加目录*/
        String desPath =uploadPath+file.getOriginalFilename();
        /*创建目标文件*/
        File desfile=new File(desPath);
        try {
            FileCopyUtils.copy(file.getBytes(),desfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "images" + File.separator+file.getOriginalFilename();

    }
    @RequestMapping(value = "visitorLog.entrance")
    public String visitorLogEntrance(){
        return "visitor/visitorLogin";
    }
    @RequestMapping(value = "visitorLog.do")
    public String visitorLog(@ModelAttribute Visitor visitor, HttpSession session, Model model){
        Visitor visitor1 = visitorService.visitorLogin(visitor);
        String info = null;
        if (visitor1 == null) {
            info = "wrong name or password!";
            model.addAttribute("info",info);
            return "index";
        }
        model.addAttribute("visitor",visitor1);
        session.setAttribute("visitor",visitor1);
        /*判断是否是员工，访客id页加进去*/
        Employee employee = new Employee();
        employee.setVisitorId(visitor1.getId());
        List<Employee> employees = employeeService.queryEmp(employee);
        if (employees != null&&employees.size()>0) {
            employee = employees.get(0);
            model.addAttribute("employee",employee);
            session.setAttribute("employee",employee);
            return "employee/success";
        }
        /*不是员工，跳转到visitor成功页*/
        return "visitor/success";
    }
    @RequestMapping(value = "visitorAddPesonalMsg.entrance")
    public String visitorAddMsgEntrance(HttpSession session,Model model){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        model.addAttribute("visitor",visitor);
        return "visitor/visitorPersonalMsg/visitorAddPersonalMsg";
    }
    @RequestMapping(value = "visitorAddPersonalMsg.do")
    public String visitorAddMsgEntrance(HttpSession session,Model model,@ModelAttribute Visitor visitor){
        Visitor visitor0 = (Visitor) session.getAttribute("visitor");
        visitor.setId(visitor0.getId());
        boolean b = visitorService.updateVisitorPersonMsg(visitor);
        if(b){
            model.addAttribute("info","update OK!");
        }else{
            model.addAttribute("info","update Failed!");
        }
        return "visitor/success";
    }
    @RequestMapping(value ="checkName.oper")
    public @ResponseBody String checkName(
            @RequestParam(value = "visitorName",required = false)String visitorNameUncheck){
        Visitor visitor0 = new Visitor();
        visitor0.setVName(visitorNameUncheck);
        Visitor visitor = visitorService.queryVisitor(visitor0);
        if (visitor == null) {
            return null;
        }else{
            return "name is already existed!";
        }
    }
}