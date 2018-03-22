package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.DeptAndJob;
import com.archon.service.DeptAndJobService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
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
/*    @RequestMapping(value = "showJobAjax.view")
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
    }*/

    @RequestMapping(value = "showJobAjax.view",produces = "application/json;charset=UTF-8")
    public @ResponseBody String queryApartment(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        DeptAndJob deptAndJob = new DeptAndJob();
        deptAndJob.setCompanyId(companyId);
        List<DeptAndJob> deptAndJobs = deptAndJobService.queryDeptAndJob(deptAndJob);
        ObjectMapper mapper = new ObjectMapper();
        StringWriter w = new StringWriter();
        //Convert between List and JSON
        try {
            mapper.writeValue(w, deptAndJobs);//开始序列化
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println(w.toString()); //输出json格式的字符串
        return w.toString(); //将json格式的字符串返回给前台
    }
}