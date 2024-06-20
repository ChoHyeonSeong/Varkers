package com.jhs.varkers.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public AccountDTO readAccount(@RequestParam Long accountId){
        return accountService.readAccount(accountId);
    }

    @PutMapping
    public String updateAccount(@RequestBody AccountDTO account){
        accountService.updateAccount(account);
        return "OK";
    }

    @DeleteMapping
    public String deleteAccount(@RequestParam Long accountId){
        accountService.deleteAccount(accountId);
        return "OK";
    }

}
