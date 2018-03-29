package com.archon.controller;

import com.archon.po.*;
import com.archon.service.CompanyService;
import com.archon.service.DeptAndJobService;
import com.archon.service.DeptService;
import com.archon.service.RecruitmentService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Controller
@RequestMapping(value = "recruit")
public class RecruitmentController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private DeptAndJobService deptAndJobService ;
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "adminRecruit.entrance")
    public  String adminRecruitEntrance(Model model, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        Department d = new Department();
        d.setCompanyId(admin.getCompanyId());
        List<Department> dList = deptService.queryDept(d);
        ObjectMapper mapper = new ObjectMapper();
        StringWriter w = new StringWriter();
        try {
            mapper.writeValue(w,dList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("dList",w);
        int dSize = dList.size();
        model.addAttribute("dSize",dSize);
        Company company = new Company();
        company.setId(admin.getCompanyId());
        String compName = companyService.queryCompany(company).getCName();
        model.addAttribute("compName",compName);
        return "admin/adminNewRecruitment/adminNewRecruitment";
    }
   @RequestMapping(value = "adminAddRecruit.do")
    public String adminAddRecruit(HttpSession session, Model model,
/*                                  @RequestParam(value = "jobAndDeptId",required = false) String djId, */
                                  @RequestParam(value = "deptName",required = false)String deptIdStr,
                                  @RequestParam(value = "jobName",required = false)String jobIdStr,
                                  @ModelAttribute Recruitment recruitment){
       Admin admin = (Admin) session.getAttribute("admin");
       int deptId = Integer.parseInt(deptIdStr);
       int jobId = Integer.parseInt(jobIdStr);
       DeptAndJob deptAndJob = new DeptAndJob();
       deptAndJob.setCompanyId(admin.getCompanyId());
       deptAndJob.setDeptId(deptId);
       deptAndJob.setJobId(jobId);
       List<DeptAndJob> deptAndJobs = deptAndJobService.queryDeptAndJob(deptAndJob);
       System.out.println(deptAndJob+"---query---");
       System.out.println(deptAndJobs);
       if (deptAndJobs==null||deptAndJobs.size()==0){
           model.addAttribute("info","添加失败");
           return "admin/adminNewRecruitment/adminNewRecruitment";
       }
       recruitment.setJobAndDeptId(deptAndJobs.get(0).getId());
       recruitment.setCreaterId(admin.getId());
       System.out.println(recruitment);
       boolean b = recruitmentService.newRec(recruitment);
       System.out.println(b);
       if(b){
           model.addAttribute("Recruit",recruitment);
       }else{
           model.addAttribute("info","添加失败");
       }
       return "admin/adminNewRecruitment/adminNewRecruitment";
    }
    @RequestMapping(value = "showRec")
    public String visitorViewRec(Model model){
        List<Recruitment> recruitments = recruitmentService.queryRec(new Recruitment());
        model.addAttribute("Recruit",recruitments);
        return "visitor/visitorRecruitment/visitorScanRecruit";
    }
    @RequestMapping(value = "showRec/{recruitmentId}")
    public String visitorViewRecWithRecId(Model model, @PathVariable(value = "recruitmentId") String recuitmentIdl){
        Recruitment recruitment = new Recruitment();
        int recId = Integer.parseInt(recuitmentIdl);
        recruitment.setId(recId);
        List<Recruitment> recruitments = recruitmentService.queryRec(recruitment);
        model.addAttribute("Recruit",recruitments.get(0));
        return "visitor/visitorRecruitment/visitorRecruitDetial";
    }
}