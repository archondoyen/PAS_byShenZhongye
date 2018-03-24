package com.archon.service.impl;

import com.archon.dao.EmpAndTrainDao;
import com.archon.po.EmpAndTrain;
import com.archon.service.EmpAndTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "EmpAndTrainService")
public class EmpAndTrainServiceImpl implements EmpAndTrainService {
    @Autowired
    private EmpAndTrainDao empAndTrainDao;
    @Override
    public boolean addET(EmpAndTrain empAndTrain) {
        return empAndTrainDao.addET(empAndTrain);
    }

    @Override
    public boolean updateET(EmpAndTrain empAndTrain) {
        return empAndTrainDao.updateET(empAndTrain);
    }

    @Override
    public List<EmpAndTrain> queryET(EmpAndTrain empAndTrain) {
        return empAndTrainDao.queryET(empAndTrain);
    }

    @Override
    public boolean deleteET(EmpAndTrain empAndTrain) {
        return empAndTrainDao.deleteET(empAndTrain);
    }
}