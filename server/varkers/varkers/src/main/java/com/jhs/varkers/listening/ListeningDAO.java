package com.jhs.varkers.listening;

import java.util.List;

public interface ListeningDAO {
    List<ListeningEntity> readByAccountId(Long accountId);
    List<ListeningEntity> readByListeningId(Long listeningId);
    ListeningEntity readByAccountIdAndListeningId(Long accountId,Long listeningId);
    void deleteByAccountIdAndListeningId(Long accountId,Long listeningId);
    boolean existsByAccountIdAndListeningId(Long accountId,Long listeningId);
}
