package com.archon.service.impl;

import com.archon.dao.TrainDao;
import com.archon.po.Train;
import com.archon.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TrainService")
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;
    @Override
    public boolean addTrain(Train train) {
        return trainDao.addTrain(train);
    }

    @Override
    public boolean updateTrain(Train train) {
        return trainDao.updateTrain(train);
    }

    @Override
    public List<Train> queryTrain(Train train) {
        return trainDao.queryTrain(train);
    }
}