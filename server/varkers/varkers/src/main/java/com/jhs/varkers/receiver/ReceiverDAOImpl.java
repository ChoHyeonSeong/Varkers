package com.jhs.varkers.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReceiverDAOImpl implements ReceiverDAO {
    private final ReceiverRepository repo;

    @Override
    public void createReceivers(List<ReceiverEntity> entities) {
        repo.saveAll(entities);
    }

    @Override
    public List<ReceiverEntity> readReceivers(Long varkId) {
        return repo.findByVarkId(varkId);
    }
}
