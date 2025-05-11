package com.example.spring_program.controller;

import com.example.spring_program.cervice.AccountService;
import com.example.spring_program.entity.Account;
import com.example.spring_program.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    // Пример запроса в body
//    {
//        "email": "Maximka_lord@list.ru",
//            "balance": "12213",
//            "creationDate": "2022-12-05T10:15:30"
//    }

    @GetMapping(path = "balance/{id}")
    public BigDecimal getAccountBalance(@PathVariable Long id) {
        return accountService.getAccountBalance(id);
    }


    @PostMapping("/operations/{id}")
    public ResponseEntity<Void> performOperation(@PathVariable Long id,
                                                 @RequestParam BigDecimal operation,
                                                 @RequestParam String description,
                                                 @RequestParam String type) {
        accountService.performOperation(id, operation, description, Transaction.OperationType.valueOf(type.toUpperCase()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getBalance(id));
    }

    @GetMapping("/{id}/operations")
    public ResponseEntity<List<Transaction>> getOperations(@PathVariable Long id,
                                                           @RequestParam LocalDateTime startDate,
                                                           @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(accountService.getOperations(id, startDate, endDate));
    }
}



