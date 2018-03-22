package com.archon.service;

import com.archon.po.Visitor;

public interface VisitorService {
    Object visitorRegister(Visitor visitor);
    Visitor visitorLogin(Visitor visitor);
    Visitor queryVisitorByName(String vName);
}