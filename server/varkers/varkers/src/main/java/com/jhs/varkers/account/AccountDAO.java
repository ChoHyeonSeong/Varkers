package com.jhs.varkers.account;

public interface AccountDAO {
    void createAccount(AccountEntity entity);
    AccountEntity readAccount(long id);
    void updateAccount(AccountEntity entity);
    void deleteAccount(long id);
}
