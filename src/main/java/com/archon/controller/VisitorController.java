package com.archon.controller;

import com.archon.po.Visitor;
import com.archon.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
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
    public String visitorReg(@RequestParam(value = "vPhoto",required = false) MultipartFile photo, @ModelAttribute Visitor visitor, HttpSession session, Model model){
        if (photo == null) {
            visitor.setVPhoto(null);
        }else{
            String vPhoto = saveImage(photo);
            System.out.println(vPhoto);
            visitor.setVPhoto(vPhoto);
        }
        Object b = visitorService.visitorRegister(visitor);
        String info = null;
        if(b instanceof String){
            info = (String)b;
            model.addAttribute("info",info);
            return "visitor/visitorTop";
        }
        if((Boolean) b){
            model.addAttribute("visitor",visitor);
            session.setAttribute("visitor",visitor);
            return "visitor/success";
        }
        info = "用户注册失败！";
        model.addAttribute("info",info);
        return "visitor/visitorTop";
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
            return "visitor/visitorLogin";
        }
        model.addAttribute("visitor",visitor1);
        session.setAttribute("visitor",visitor1);
        return "visitor/success";
    }
}