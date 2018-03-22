package com.archon.dao;

import com.archon.po.Visitor;

public interface VisitorDao {
    boolean addVisitor(Visitor visitor);
    boolean updateVisitor(Visitor visitor);
    Visitor queryVisitor(Visitor visitor);
    Visitor queryVisitorByName(String vName);
}