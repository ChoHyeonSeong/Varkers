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
    public String createAccount(@RequestBody AccountDTO account){
        accountService.createAccount(account);
        return "OK";
    }
    @GetMapping("/{accountId}")
    public AccountDTO readAccount(@PathVariable Long accountId){
        return accountService.readAccount(accountId);
    }
    @GetMapping("/user/{userId}")
    public List<AccountDTO> readUserAccounts(@PathVariable Long userId){
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

}
