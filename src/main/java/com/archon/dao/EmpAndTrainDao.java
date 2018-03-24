package com.archon.dao;

import com.archon.po.EmpAndTrain;

import java.util.List;

public interface EmpAndTrainDao {
    boolean addET(EmpAndTrain empAndTrain);
    boolean updateET(EmpAndTrain empAndTrain);
    List<EmpAndTrain> queryET(EmpAndTrain empAndTrain);
    boolean deleteET(EmpAndTrain empAndTrain);
}