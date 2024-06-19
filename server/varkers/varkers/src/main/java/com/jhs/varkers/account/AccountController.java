package com.jhs.varkers.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public String createAccount(){
        return "";
    }
    @GetMapping
    public String readAccount(){
        return "";
    }

    @PutMapping
    public String updateAccount(){
        return "";
    }

    @DeleteMapping
    public String deleteAccount(){
        return "";
    }

}
