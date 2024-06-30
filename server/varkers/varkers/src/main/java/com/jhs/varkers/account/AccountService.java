package com.jhs.varkers.account;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO dto);
    Long createAccountAndReturnId(AccountDTO dto);
    AccountDTO readAccount(Long id);
    List<AccountDTO> readUserAccounts(Long userId);
    void updateAccount(AccountDTO dto);
    void deleteAccount(Long id);
}
