package com.archon.service.impl;

import com.archon.dao.VisitorDao;
import com.archon.po.Visitor;
import com.archon.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "VisitorService")
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorDao visitorDao;
    @Override
    public Object visitorRegister(Visitor visitor) {
        Visitor visitor1 = visitorDao.queryVisitor(visitor);
        if (visitor1 == null) {
            boolean b = visitorDao.addVisitor(visitor);
            return b;
        }
        return "your visitor is already existed! Please change another Name~";
    }

    @Override
    public Visitor visitorLogin(Visitor visitor) {
        Visitor visitor1 = visitorDao.queryVisitor(visitor);
        return visitor1;
    }

    @Override
    public Visitor queryVisitorByName(String vName) {
        return visitorDao.queryVisitorByName(vName);
    }
}