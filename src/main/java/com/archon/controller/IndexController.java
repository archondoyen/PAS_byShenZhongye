package com.archon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "")
public class IndexController {
    @RequestMapping(value = "")
    public String indexControl(){
        return "index";
    }
    @RequestMapping(value = "logOut.do")
    public String logOutDo(HttpSession session){
        Object admin = session.getAttribute("admin");
        Object employee = session.getAttribute("employee");
        Object visitor = session.getAttribute("visitor");
        if (visitor == null) {
            session.removeAttribute("admin");
        }
        if (employee==null){
            session.removeAttribute("employee");
        }
        if (admin == null) {
            session.removeAttribute("visitor");
        }
        return "index";
    }
}