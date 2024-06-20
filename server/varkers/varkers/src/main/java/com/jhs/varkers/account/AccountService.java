package com.jhs.varkers.account;

public interface AccountService {
    void createAccount(AccountDTO dto);
    Long createAccountAndReturnId(AccountDTO dto);
    AccountDTO readAccount(Long id);
    void updateAccount(AccountDTO dto);
    void deleteAccount(Long id);
}
