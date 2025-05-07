package com.example.spring_program.cervice;

import com.example.spring_program.entity.Account;
import com.example.spring_program.repository.AccountRepository;
import com.example.spring_program.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(account.getEmail());
        if (optionalAccount.isPresent()) {
            throw new IllegalStateException("Аккаунт с таким email уже существует!");
        }
        return accountRepository.save(account);
    }

    public BigDecimal getAccountBalance(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.get().getBalance();
    }

    public void performTransaction(Long id, BigDecimal operation, String description, String type) {

    }
}
