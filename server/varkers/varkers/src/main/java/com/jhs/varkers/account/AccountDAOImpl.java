package com.jhs.varkers.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountDAOImpl implements AccountDAO {
    private final AccountRepository repo;

    @Override
    public AccountEntity createAccount(AccountEntity entity) {
        return repo.save(entity);
    }

    @Override
    public AccountEntity readAccount(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<AccountEntity> readAccounts(List<Long> accountIds) {
        return repo.findByIdIn(accountIds);
    }

    @Override
    public List<AccountEntity> readUserAccounts(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }
}
