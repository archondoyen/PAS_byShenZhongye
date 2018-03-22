package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Company;
import com.archon.po.Job;
import com.archon.service.JobService;
import com.archon.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "job")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private JobTypeService jobTypeService;
    @RequestMapping(value = "adminAddJob.Entrance")
    public String adminJobEntrance(){return "admin/adminJobManager/adminManageJob";}
/*    @RequestMapping(value = "showJob.view")
    public String showJob(HttpSession session, Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        Job job = new Job();
        job.setCompanyId(companyId);
        List<Job> jobs = jobService.queryJob(job);
        model.addAttribute("jobs",jobs);
        return "admin/adminJobManager/adminShowJob";
    }*/

}