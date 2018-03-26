package com.archon.service.impl;

import com.archon.dao.SalayDao;
import com.archon.po.Salay;
import com.archon.service.SalayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "SalayService")
public class SalayServiceImpl implements SalayService {
    @Autowired
    private SalayDao salayDao;
    @Override
    public boolean addSalay(Salay salay) {
        return salayDao.addSalay(salay);
    }

    @Override
    public boolean updateSalay(Salay salay) {
        return salayDao.updateSalay(salay);
    }

    @Override
    public List<Salay> querySalay(Salay salay) {
        return salayDao.querySalay(salay);
    }

    @Override
    public List<Salay> findSalayNotGet(Salay salay) {
        List<Salay> salays = querySalay(salay);
        if (salays == null||salays.size()==0) {
            return salays;
        }
        List<Salay> salayNotGet = new ArrayList<>();
        for (Salay salayItem : salays) {
            if(salayItem.getGetSalDate()==null){
                salayNotGet.add(salayItem);
            }
        }
        return salayNotGet;
    }

    @Override
    public Double SumSalay(Salay salay) {
        Double totalSalay =salay.getBase().doubleValue() + salay.getWorkerPerformance().doubleValue() + salay.getRewardAndPunish().doubleValue();
        totalSalay*=Salay.AVG_RATIO;
        return totalSalay;
    }
}