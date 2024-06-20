package com.jhs.varkers.account;

public interface AccountDAO {
    void createAccount(AccountEntity entity);
    AccountEntity readAccount(Long id);
    void deleteAccount(Long id);
}
