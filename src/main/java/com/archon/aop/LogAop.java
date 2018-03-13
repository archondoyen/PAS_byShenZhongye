package com.archon.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAop {
    @Around(value = ("execution(* com.archon.dao..*.*(..))"))
    public Object around(){
        return null;
    }
}