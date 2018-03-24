package com.archon.dao;

import com.archon.po.Train;

import java.util.List;

public interface TrainDao {
    boolean addTrain(Train train);
    boolean updateTrain(Train train);
    List<Train> queryTrain(Train train);
}