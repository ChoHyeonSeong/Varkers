package com.jhs.varkers.account;

public interface AccountService {
    void createAccount(AccountDTO);
    AccountDTO readAccount(long id);
    void updateAccount(AccountDTO dto);
    void deleteAccount(long id);
}
