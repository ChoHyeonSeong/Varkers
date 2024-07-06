package com.jhs.varkers.receiver;

import java.util.List;

public interface ReceiverDAO {
    void createReceivers(List<ReceiverEntity> entities);
    List<ReceiverEntity> readReceivers(Long varkId);
}
