package com.jhs.varkers.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByUserId(Long userId);
    List<AccountEntity> findByIdIn(List<Long> accountIds);
    Boolean existsByName(String name);
}
