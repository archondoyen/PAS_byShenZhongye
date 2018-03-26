package com.archon.dao;

import com.archon.po.Salay;

import java.util.List;

public interface SalayDao {
    boolean addSalay(Salay salay);
    boolean updateSalay(Salay salay);
    List<Salay> querySalay(Salay salay);
}