package com.jhs.varkers.listening;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface ListeningDAO {
    List<ListeningEntity> readByAccountId(Long accountId);
    List<ListeningEntity> readByListeningId(Long listeningId);
    ListeningEntity readByAccountIdAndListeningId(Long accountId,Long listeningId);
    void deleteByAccountIdAndListeningId(Long accountId,Long listeningId);
}
