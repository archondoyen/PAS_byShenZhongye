package com.archon.service.impl;

import com.archon.dao.RewardAndPunishDao;
import com.archon.po.RewardPunish;
import com.archon.service.RewardAndPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "RewardAndPunish")
public class RewardAndPunishServiceImpl implements RewardAndPunishService {
    @Autowired
    private RewardAndPunishDao rewardAndPunishDao;
    @Override
    public boolean addRP(RewardPunish rp) {
        return rewardAndPunishDao.addRP(rp);
    }

    @Override
    public boolean update(RewardPunish rp) {
        return rewardAndPunishDao.update(rp);
    }

    @Override
    public List<RewardPunish> queryRewardPunish(RewardPunish rp) {
        return rewardAndPunishDao.queryRewardPunish(rp);
    }
}