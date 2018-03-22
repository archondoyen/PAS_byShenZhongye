package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Department;
import com.archon.service.DeptService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Controller
@RequestMapping(value = "Dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "adminNewDept.entrance")
    public String adminNewDeptEntrance(){
        return "admin/adminNewDept/adminNewDept";
    }
    @RequestMapping(value = "adminNewDept.do")
    public String adminNewDept(@ModelAttribute Department department, HttpSession session, Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        department.setCompanyId(companyId);
        boolean b = deptService.newDept(department);
        if (b) {
            model.addAttribute("department",department);
        }else{
            String info = "公司信息加入失败！";
            model.addAttribute("info",info);
        }
        return "admin/adminNewDept/adminNewDept";
    }
    @RequestMapping(value = "adminDept.view")
    public String adminManageDept(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        Department department = new Department();
        department.setCompanyId(companyId);
        List<Department> departments = deptService.queryDept(department);
        model.addAttribute("deptList", departments);
        return "admin/adminManageDept/adminManageDept";
    }
    @RequestMapping(value = "deleteDept.do")
    public void adminDeletDept(HttpServletResponse response, @RequestParam(value = "deptId") String deptId,@RequestParam(value = "oper") String oper) throws IOException {
        int dId = Integer.parseInt(deptId);
        Department department = new Department();
        department.setId(dId);
        if(oper.equals("delete")){
            boolean b = deptService.deletDept(department);
            System.out.println("controller 的是"+b);
            response.getWriter().print(b);
        }
    }
    @RequestMapping(value = "showDeptAjax.view",produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String queryDepartment(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        Integer companyId = admin.getCompanyId();
        Department department = new Department();
        department.setCompanyId(companyId);
        List<Department> departments = deptService.queryDept(department);
        ObjectMapper mapper = new ObjectMapper();
        StringWriter w = new StringWriter();
        //Convert between List and JSON
        try {
            mapper.writeValue(w, departments);//开始序列化
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println(w.toString()); //输出json格式的字符串
        return w.toString(); //将json格式的字符串返回给前台
    }
}