package com.jhs.varkers.listening;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ListeningDAOImpl implements ListeningDAO {
    private final ListeningRepository listeningRepo;

    @Override
    public List<ListeningEntity> readByAccountId(Long accountId) {
        return listeningRepo.findByAccountId(accountId);
    }

    @Override
    public List<ListeningEntity> readByListeningId(Long listeningId) {
        return listeningRepo.findByListeningId(listeningId);
    }

    @Override
    public ListeningEntity readByAccountIdAndListeningId(Long accountId, Long listeningId) {
        return listeningRepo.findOneByAccountIdAndListeningId(accountId, listeningId);
    }

    @Override
    public void deleteByAccountIdAndListeningId(Long accountId, Long listeningId) {
        listeningRepo.deleteByAccountIdAndListeningId(accountId, listeningId);
    }
}
