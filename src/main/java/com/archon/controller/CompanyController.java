package com.archon.controller;

import com.archon.po.Admin;
import com.archon.po.Company;
import com.archon.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "addCompany.do")
    public String addCompany(@ModelAttribute Company company, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin) session.getAttribute("admin");
        String info = null;
        if (admin == null) {
            return "admin/adminLogin";
        }
        if (admin.getCompanyId() != null) {
            return "admin/success";
        }
        boolean b = companyService.addCompany(company);
        if (b){
            info = company +"添加成功！";
            request.setAttribute("info",info);
            request.getRequestDispatcher("admin/success").forward(request,response);
            return null;
        }
        return "admin/Dustbin/adminAddCompany";
    }
}