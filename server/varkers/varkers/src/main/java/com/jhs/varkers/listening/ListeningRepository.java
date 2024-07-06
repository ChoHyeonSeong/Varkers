package com.jhs.varkers.listening;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListeningRepository extends JpaRepository<ListeningEntity,Long> {
    List<ListeningEntity> findByAccountId(Long accountId);
    List<ListeningEntity> findByListeningId(Long listeningId);
    ListeningEntity findOneByAccountIdAndListeningId(Long accountId,Long listeningId);
    void deleteByAccountIdAndListeningId(Long accountId,Long listeningId);
    boolean existsByAccountIdAndListeningId(Long accountId,Long listeningId);
}
