package com.jhs.varkers.vark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VarkRepository extends JpaRepository<VarkEntity, Long>, VarkCustomRepository {
    List<VarkEntity> findByAccountId(Long accountId);
}
