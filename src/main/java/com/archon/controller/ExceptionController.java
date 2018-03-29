package com.archon.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public String err500(NullPointerException e){
        return "redirect:/staticPages/500.html";
    }
}