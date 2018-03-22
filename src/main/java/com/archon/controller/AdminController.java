package com.archon.controller;

import com.archon.po.*;
import com.archon.service.AdminService;
import com.archon.service.CompanyService;
import com.archon.service.DeptAndJobService;
import com.archon.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value ="admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobService jobService;
    @Autowired
    private DeptAndJobService deptAndJobService;

    @RequestMapping(value = "/adminLogFirst.do")
    public String adminLogFirst(){
        return "admin/adminLogin";
    }
    @RequestMapping(value = "adminSuccess.do")
    public String adminSuccess(){
        return "admin/success";
    }

    @RequestMapping(value = "/adminLog.do")
    public String adminLog(@ModelAttribute Admin admin, HttpSession session, Model model){
        Admin admin1 = adminService.loginAdmin(admin);
        if (admin1 == null) {
            String info = "用户名或密码不存在！";
            model.addAttribute("info",info);
            return "admin/adminLogin";
        }
        session.setAttribute("admin",admin1);
        model.addAttribute("admin",admin1);
        return "admin/success";
    }
    @RequestMapping(value = "adminCompany.view")
    public String myCompany(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        Admin admin = (Admin) session.getAttribute("Admin");
        Integer companyId = admin.getCompanyId();
        String info = null;
        if (companyId == null) {
            info = "公司信息空";
            request.setAttribute("info",info);
            request.getRequestDispatcher("admin/showCompany/adminShowCompany").forward(request,response);
/*
            request.getRequestDispatcher("WEB-INF/views/admin/showCompany/adminShowCompany.jsp").forward(request,response);
*/
            return "admin/success";
            /*return "redirect:admin/showCompany/adminShowCompany";*/
        }
        Company company = new Company();
        company.setId(companyId);
        Company company1 = companyService.queryCompany(company);
        if (company1 == null) {
            info = "公司信息空";
            request.setAttribute("info",info);
            request.getRequestDispatcher("WEB-INF/views/admin/success.jsp").forward(request,response);
/*            return "redirect:admin/success";*/
            return "admin/success";
        }
        request.setAttribute("company",company1);
        request.getRequestDispatcher("WEB-INF/views/admin/showCompany/adminShowCompany.jsp").forward(request,response);
        return "admin/showCompany/adminShowCompany";
    }
    @RequestMapping(value = "adminAddJob.do",produces = "application/json;charset=UTF-8")
    public String queryApartment(HttpSession session,Model model,@RequestParam(value="deptId") String deptIdStr,@ModelAttribute Job Job) {
        /*加公司id*/
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        DeptAndJob deptAndJob = new DeptAndJob();
        deptAndJob.setCompanyId(companyId);
        /*加部门id*/
        int deptId = Integer.parseInt(deptIdStr);
        deptAndJob.setDeptId(deptId);
        jobService.addJob(Job);
        deptAndJobService.adminNewDeptAndJob(deptAndJob);
        return "admin/adminNewJob/adminManageJob";
    }
}