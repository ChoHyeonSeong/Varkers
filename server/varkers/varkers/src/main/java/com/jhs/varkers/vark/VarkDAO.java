package com.jhs.varkers.vark;

import com.jhs.varkers.account.AccountEntity;

import java.util.List;

public interface VarkDAO {
    void createVark(VarkEntity entity);
    VarkEntity readVark(Long id);
    void deleteVark(Long id);
    List<VarkEntity> readVarkOfAccount(Long accountId);
    List<VarkEntity> readVarkRoad(List<Long> listeningList);
}
