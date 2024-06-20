package com.jhs.varkers.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountDAOImpl implements AccountDAO {
    private final AccountRepository repo;

    @Override
    public void createAccount(AccountEntity entity) {
        repo.save(entity);
    }

    @Override
    public AccountEntity readAccount(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }
}
