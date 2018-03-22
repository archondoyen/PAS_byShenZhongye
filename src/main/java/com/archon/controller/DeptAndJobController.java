package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.DeptAndJob;
import com.archon.service.DeptAndJobService;
import com.archon.service.impl.DeptAndJobServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "deptAndJob")
public class DeptAndJobController {
    @Autowired
    private DeptAndJobService deptAndJobService;
    @RequestMapping(value = "showJob.view")
    public String adminShowDeptAndJob(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        DeptAndJob deptAndJob = new DeptAndJob();
        deptAndJob.setCompanyId(companyId);
        List<DeptAndJob> deptAndJobs = deptAndJobService.queryDeptAndJob(deptAndJob);
        model.addAttribute("deptAndJobs",deptAndJobs);
        return "admin/adminJobManager/adminShowDeptAndJob";
    }
    @RequestMapping(value = "showJobAjax.view")
    public Model adminShowDeptAndJobAjax(HttpSession session, Model model, HttpServletResponse response){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        DeptAndJob deptAndJob = new DeptAndJob();
        deptAndJob.setCompanyId(companyId);
        List<DeptAndJob> deptAndJobs = deptAndJobService.queryDeptAndJob(deptAndJob);
        for (DeptAndJob andJob : deptAndJobs) {
            System.out.println(andJob);
        }
        model.addAttribute("deptAndJobs",deptAndJobs);
        return model;
    }
}