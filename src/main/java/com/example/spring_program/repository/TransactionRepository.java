package com.example.spring_program.repository;

import com.example.spring_program.entity.Account;
import com.example.spring_program.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//    List<Transaction> findByAccountAndExecutedAtBetween (Account account, LocalDateTime startDate, LocalDateTime andDate);

    //List<Transaction> findByAccountAndExecutedAtBetween(Long accountId, LocalDateTime date);

    @Query("SELECT o FROM Transaction o WHERE o.account.id = :accountId AND o.dateOfExecution BETWEEN :startDate AND :endDate")
    List<Transaction> findByAccountIdAndExecutedAtBetween(@Param("accountId") Long accountId,
                                                          @Param("startDate") LocalDateTime startDate,
                                                          @Param("endDate") LocalDateTime endDate);
}
