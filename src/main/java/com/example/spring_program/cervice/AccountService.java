package com.example.spring_program.cervice;

import com.example.spring_program.entity.Account;
import com.example.spring_program.entity.Transaction;
import com.example.spring_program.repository.AccountRepository;
import com.example.spring_program.repository.TransactionRepository;
import jdk.dynalink.Operation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

//    public BigDecimal getBalanceOnDate (Long accountId, LocalDateTime date){
//        Account account = accountRepository.findById(accountId).orElseThrow();
//        List<Transaction> operation = transactionRepository.findByAccountAndExecutedAtBetween(accountId, date);
//
//        BigDecimal balance = account.getBalance();
//
//        for (Transaction transactions : operation) {
//            if (transactions.getType() == Transaction.OperationType.WITHDRAWAL){
//                balance = balance.subtract(transactions.getOperation());
//            } else {
//                balance = balance.add(transactions.getOperation());
//            }
//        }
//        return balance;
//    }



public void performOperation(Long accountId, BigDecimal operation, String description, Transaction.OperationType type) {
    Account account = accountRepository.findById(accountId).orElseThrow();
    Transaction transaction = new Transaction();
    transaction.setOperation(operation);
    transaction.setDescription(description);
    transaction.setDateOfExecution(LocalDateTime.now());
    transaction.setType(type);
    transaction.setAccount(account);

    if (type == Transaction.OperationType.WITHDRAWAL) {
        account.setBalance(account.getBalance().subtract(operation));
    } else {
        account.setBalance(account.getBalance().add(operation));
    }

    transactionRepository.save(transaction);
    accountRepository.save(account);
}

    public BigDecimal getBalance(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow().getBalance();
    }

    public List<Transaction> getOperations(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByAccountIdAndExecutedAtBetween(accountId, startDate, endDate);
    }
}



















