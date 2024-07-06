package com.jhs.varkers.listening;

import java.util.List;

public interface ListeningService {
    List<ListeningDTO> readByAccountId(Long accountId);
    List<ListeningDTO> readByListeningId(Long listeningId);
    ListeningDTO readByAccountIdAndListeningId(Long accountId,Long listeningId);
    void deleteByAccountIdAndListeningId(Long accountId,Long listeningId);
    boolean existsByAccountIdAndListeningId(Long accountId,Long listeningId);
}
