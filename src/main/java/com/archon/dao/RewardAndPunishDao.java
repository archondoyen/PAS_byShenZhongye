package com.archon.dao;

import com.archon.po.RewardPunish;

import java.util.List;

public interface RewardAndPunishDao {
    boolean addRP(RewardPunish rp);
    boolean update(RewardPunish rp);
    List<RewardPunish> queryRewardPunish(RewardPunish rp);
}