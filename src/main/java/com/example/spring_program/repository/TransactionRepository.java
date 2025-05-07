package com.example.spring_program.repository;

import com.example.spring_program.entity.Account;
import com.example.spring_program.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountAndExecutedAtBetween (Account account, LocalDateTime startDate, LocalDateTime andDate);
}
