package com.jhs.varkers.account;

import java.util.List;

public interface AccountDAO {
    AccountEntity createAccount(AccountEntity entity);
    AccountEntity readAccount(Long id);
    List<AccountEntity> readUserAccounts(Long userId);
    List<AccountEntity> readAccounts(List<Long> accountIds);
    void deleteAccount(Long id);
}
