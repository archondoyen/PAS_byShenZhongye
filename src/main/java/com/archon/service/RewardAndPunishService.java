package com.archon.service;

import com.archon.po.RewardPunish;

import java.util.List;

public interface RewardAndPunishService {
    boolean addRP(RewardPunish rp);
    boolean update(RewardPunish rp);
    List<RewardPunish> queryRewardPunish(RewardPunish rp);
}