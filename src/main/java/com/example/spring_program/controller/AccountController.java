package com.example.spring_program.controller;

import com.example.spring_program.cervice.AccountService;
import com.example.spring_program.entity.Account;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.createAccount(account);
    }

}
