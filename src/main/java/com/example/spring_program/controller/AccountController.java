package com.example.spring_program.controller;

import com.example.spring_program.cervice.AccountService;
import com.example.spring_program.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping(path = "balance/{id}")
    public BigDecimal getAccountBalance(@PathVariable Long id) {
        return accountService.getAccountBalance(id);
    }

    @PostMapping(path = "balance/transaction/{id}")
    public ResponseEntity<Void> performTransaction(@PathVariable Long id,
                                                   @RequestParam BigDecimal operation,
                                                   @RequestParam String description,
                                                   @RequestParam String type) {
        accountService.performTransaction(id, operation, description, type);
        return ResponseEntity.ok().build();
    }


//    @GetMapping(path = "balance/transaction/")
//    public Transaction getTransaction(@PathVariable Long id,
//                                      @RequestParam LocalDateTime startTime,
//                                      @RequestParam LocalDateTime endTime) {
//        return accountService.getTransaction(id, startTime, endTime);


}



