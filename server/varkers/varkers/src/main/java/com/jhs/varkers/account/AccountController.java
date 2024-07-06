package com.jhs.varkers.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountDTO createAccount(@RequestBody AccountDTO account){
        return accountService.createAccount(account);
    }
    @GetMapping("/{accountId}")
    public AccountDTO readAccount(@PathVariable Long accountId){
        return accountService.readAccount(accountId);
    }
    @GetMapping
    public AccountDTO readAccountByName
            (@RequestParam String name){
        return accountService.readAccount(accountId);
    }
    @GetMapping
    public List<AccountDTO> readAccounts(@RequestParam("accounts") List<Long> accountIds){
        return accountService.readAccounts(accountIds);
    }
    @GetMapping("/user/{userId}")
    public List<AccountDTO> readUserAccountsByUserId(@PathVariable Long userId){
        return accountService.readUserAccounts(userId);
    }

    @PutMapping
    public String updateAccount(@RequestBody AccountDTO account){
        accountService.updateAccount(account);
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "OK";
    }

    @GetMapping("/check")
    public Boolean checkName(@RequestParam String name){
        return accountService.existsByName(name);
    }
}
