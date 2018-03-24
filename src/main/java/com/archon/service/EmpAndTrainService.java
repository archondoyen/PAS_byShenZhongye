package com.archon.service;

import com.archon.po.EmpAndTrain;

import java.util.List;

public interface EmpAndTrainService {
    boolean addET(EmpAndTrain empAndTrain);
    boolean updateET(EmpAndTrain empAndTrain);
    List<EmpAndTrain> queryET(EmpAndTrain empAndTrain);
    boolean deleteET(EmpAndTrain empAndTrain);
}