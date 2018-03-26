package com.archon.service;

import com.archon.po.Salay;

import java.util.List;

public interface SalayService {
    boolean addSalay(Salay salay);
    boolean updateSalay(Salay salay);
    List<Salay> querySalay(Salay salay);
    List<Salay> findSalayNotGet(Salay salay);
    Double SumSalay(Salay salay);
}