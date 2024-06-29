package com.jhs.varkers.account;

import java.util.List;

public interface AccountDAO {
    void createAccount(AccountEntity entity);
    AccountEntity readAccount(Long id);
    List<AccountEntity> readUserAccounts(Long userId);
    void deleteAccount(Long id);
}
